package ru.practicum.ewm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.ewm.model.Event;
import ru.practicum.ewm.model.EventState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Поиск события по ID и ID инициатора
    Optional<Event> findByIdAndInitiatorId(long id, Long initiatorId);

    // Поиск события по ID и статусу
    Optional<Event> findByIdAndState(long eventId, EventState state);

    // Получение всех событий пользователя с пагинацией
    List<Event> findAllByInitiatorId(long initiatorId, Pageable pageable);

    // Поиск событий по категории
    List<Event> findByCategoryId(long categoryId);

    // Поиск событий для администратора с фильтрацией по пользователям, статусам, категориям и датам
    @Query("""
            SELECT e
              FROM Event e
             WHERE (:users IS NULL OR e.initiator.id IN :users)
               AND (:states IS NULL OR e.state IN :states)
               AND (:categories IS NULL OR e.category.id IN :categories)
               AND e.eventDate >= COALESCE(:rangeStart, e.eventDate)
               AND e.eventDate <= COALESCE(:rangeEnd,   e.eventDate)
             ORDER BY e.id
            """)
    List<Event> findAdminEvents(
            @Param("users") List<Long> users,
            @Param("states") List<EventState> states,
            @Param("categories") List<Long> categories,
            @Param("rangeStart") LocalDateTime rangeStart,
            @Param("rangeEnd") LocalDateTime rangeEnd,
            Pageable pageable
    );

    // Поиск событий для публичного доступа с расширенной фильтрацией
    @Query("""
            SELECT e
              FROM Event e
             WHERE e.state = :state
               AND (:text IS NULL
                    OR (LOWER(e.annotation) LIKE %:text%
                        OR LOWER(e.description) LIKE %:text%
                    )
               )
               AND (:categories IS NULL OR e.category.id IN :categories)
               AND (:paid IS NULL OR e.paid = :paid)
               AND e.eventDate >= COALESCE(:rangeStart, e.eventDate)
               AND e.eventDate <= COALESCE(:rangeEnd,   e.eventDate)
               AND (:onlyAvailable IS NULL
                    OR :onlyAvailable = false
                    OR COALESCE(e.participantLimit, 0) = 0
                    OR COALESCE(e.confirmedRequests, 0) < COALESCE(e.participantLimit, 0)
               )
            """)
    List<Event> findEvents(
            @Param("text") String text,
            @Param("categories") List<Long> categories,
            @Param("paid") Boolean paid,
            @Param("rangeStart") LocalDateTime rangeStart,
            @Param("rangeEnd") LocalDateTime rangeEnd,
            @Param("onlyAvailable") Boolean onlyAvailable,
            @Param("state") EventState state,
            Pageable pageable
    );
}