package ru.practicum.ewm.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    // Создание нового события пользователем
    EventFullDto addEvent(long userId, EventCreateDto eventCreateDto);

    // Получение полной информации о событии для публичного доступа
    EventFullDto getEvent(long eventId, String uri, String ip);

    // Получение событий для публичного доступа с фильтрацией
    List<EventShortDto> getEvents(
            String text,
            List<Long> categories,
            Boolean paid,
            LocalDateTime rangeStart,
            LocalDateTime rangeEnd,
            Boolean onlyAvailable,
            String sort,
            int from,
            int size,
            String uri,
            String ip
    );

    // Получение события пользователя по ID
    EventFullDto getUserEvent(long userId, long eventId);

    // Получение всех событий пользователя с пагинацией
    List<EventShortDto> getUserEvents(long userId, Pageable pageable);

    // Получение событий для администратора с фильтрацией
    List<EventFullDto> getAdminEvents(
            List<Long> users,
            List<String> states,
            List<Long> categories,
            LocalDateTime rangeStart,
            LocalDateTime rangeEnd,
            Pageable pageable
    );

    // Обновление события пользователем
    EventFullDto updateEventByUser(long userId, long eventId, EventUpdateUserDto eventUpdateUserDto);

    // Обновление события администратором
    EventFullDto updateEventByAdmin(long eventId, EventUpdateAdminDto eventUpdateAdminDto);
}