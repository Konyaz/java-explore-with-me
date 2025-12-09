package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.practicum.ewm.dto.EventCreateDto;
import ru.practicum.ewm.dto.EventFullDto;
import ru.practicum.ewm.dto.EventPublicFullDto;
import ru.practicum.ewm.dto.EventShortDto;
import ru.practicum.ewm.model.Event;

// Преобразование между DTO и Entity для объектов Event
@Mapper(
        componentModel = "spring",
        uses = {UserMapper.class, CategoryMapper.class} // Используется UserMapper и CategoryMapper
)
public interface EventMapper {

    // Преобразование DTO создания события в Entity (без категории и инициатора)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "initiator", ignore = true)
    Event toEvent(EventCreateDto eventCreateDto);

    // Преобразование Entity события в DTO с полной информацией (включая приватные поля)
    @Mapping(target = "initiator", qualifiedByName = "toUserShortDto")
    @Mapping(target = "category", qualifiedByName = "toCategoryDto")
    EventFullDto toEventFullDto(Event event, Long views);

    // Преобразование Entity события в DTO с публичной информацией (без приватных полей)
    @Mapping(target = "initiator", qualifiedByName = "toUserShortDto")
    @Mapping(target = "category", qualifiedByName = "toCategoryDto")
    EventPublicFullDto toEventPublicFullDto(Event event, Long views);

    // Преобразование Entity события в DTO с краткой информацией (имеет имя для использования в других мапперах)
    @Named("toEventShortDto")
    EventShortDto toEventShortDto(Event event);

}