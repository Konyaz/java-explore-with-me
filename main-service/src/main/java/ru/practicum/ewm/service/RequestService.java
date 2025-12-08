package ru.practicum.ewm.service;

import ru.practicum.ewm.dto.ParticipationRequestDto;
import ru.practicum.ewm.dto.RequestStatusUpdateDto;
import ru.practicum.ewm.dto.RequestStatusUpdateResult;

import java.util.List;

public interface RequestService {

    // Создание новой заявки на участие в событии
    ParticipationRequestDto addRequest(long userId, long eventId);

    // Получение всех заявок пользователя на участие в событиях
    List<ParticipationRequestDto> getUserRequests(long userId);

    // Отмена своей заявки на участие в событии
    ParticipationRequestDto cancelRequest(long userId, long requestId);

    // Получение заявок на участие в событии пользователя
    List<ParticipationRequestDto> getEventParticipants(long userId, long eventId);

    // Изменение статуса заявок на участие в событии
    RequestStatusUpdateResult changeRequestStatus(long userId, long eventId, RequestStatusUpdateDto updateRequestDto);
}