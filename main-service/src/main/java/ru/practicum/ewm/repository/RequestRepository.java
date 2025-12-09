package ru.practicum.ewm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.model.ParticipationRequest;
import ru.practicum.ewm.model.RequestStatus;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<ParticipationRequest, Long> {

    // Получение всех заявок пользователя
    List<ParticipationRequest> findByRequesterId(Long userId);

    // Получение заявок на участие в событии пользователя
    List<ParticipationRequest> findByEventInitiatorIdAndEventId(Long userId, Long eventId);

    // Поиск заявки по пользователю и событию
    Optional<ParticipationRequest> findByRequesterIdAndEventId(Long userId, Long eventId);

    // Подсчет количества заявок на событие с определенным статусом
    Long countByEventIdAndStatus(Long eventId, RequestStatus status);

}