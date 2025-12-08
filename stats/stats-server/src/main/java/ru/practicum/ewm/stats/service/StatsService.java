package ru.practicum.ewm.stats.service;

import ru.practicum.ewm.stats.dto.EndpointHitDto;
import ru.practicum.ewm.stats.dto.ViewStatsDto;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {

    // Сохранение информации о посещении эндпоинта
    EndpointHitDto addHit(EndpointHitDto endpointHitDto);

    // Получение статистики посещений за указанный период
    List<ViewStatsDto> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique);
}