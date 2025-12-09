package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewm.dto.ParticipationRequestDto;
import ru.practicum.ewm.model.ParticipationRequest;

// Преобразование между DTO и Entity для объектов ParticipationRequest
@Mapper(componentModel = "spring")
public interface RequestMapper {

    // Преобразование Entity заявки на участие в DTO
    @Mapping(target = "event", source = "event.id")
    @Mapping(target = "requester", source = "requester.id")
    ParticipationRequestDto toRequestDto(ParticipationRequest participationRequest);

}