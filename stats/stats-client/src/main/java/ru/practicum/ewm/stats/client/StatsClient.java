package ru.practicum.ewm.stats.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;
import ru.practicum.ewm.stats.dto.EndpointHitDto;
import ru.practicum.ewm.stats.dto.ViewStatsDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class StatsClient {
    private final RestClient restClient;

    // Конструктор клиента для работы с сервисом статистики
    public StatsClient(RestClient restClient) {
        this.restClient = restClient;
    }

    // Отправка информации о посещении эндпоинта в сервис статистики
    public void addHit(EndpointHitDto endpointHitDto) {
        restClient.post().uri("/hit")
                .body(endpointHitDto)
                .retrieve()
                .toBodilessEntity();
    }

    // Получение статистики просмотров за указанный период с фильтрацией по URI и уникальности IP
    public List<ViewStatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Даты начала и окончания должны быть заданы");
        }

        if (end.isBefore(start)) {
            throw new IllegalArgumentException("Даты окончания должна быть позже даты начала");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromPath("/stats")
                .queryParam("start", start.format(formatter))
                .queryParam("end", end.format(formatter));

        if (uris != null && !uris.isEmpty()) {
            uriComponentsBuilder.queryParam("uris", String.join(",", uris));
        }

        if (unique != null) {
            uriComponentsBuilder.queryParam("unique", unique);
        }

        return restClient.get()
                .uri(uriComponentsBuilder.encode().toUriString())
                .retrieve()
                .body(new ParameterizedTypeReference<List<ViewStatsDto>>() {
                });
    }
}