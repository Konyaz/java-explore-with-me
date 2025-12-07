package ru.practicum.ewm.stats.mapper;

import org.mapstruct.Mapper;
import ru.practicum.ewm.stats.dto.EndpointHitDto;
import ru.practicum.ewm.stats.model.EndpointHit;

// Преобразование между DTO и Entity для объектов EndpointHit
@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    // Преобразование DTO в Entity для сохранения в базе данных
    EndpointHit toEndpointHit(EndpointHitDto endpointHitDto);

    // Преобразование Entity в DTO для передачи в API ответах
    EndpointHitDto toEndpointHitDto(EndpointHit endpointHit);
}