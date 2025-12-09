package ru.practicum.ewm.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(
        name = "id_gen",
        sequenceName = "event_seq",
        allocationSize = 1)
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long id;

    // Заголовок события (обязательное, максимум 120 символов)
    @Column(name = "title", nullable = false, length = 120)
    private String title;

    // Краткое описание события (обязательное, максимум 2000 символов)
    @Column(name = "annotation", nullable = false, length = 2000)
    private String annotation;

    // Полное описание события (обязательное, максимум 7000 символов)
    @Column(name = "description", nullable = false, length = 7000)
    private String description;

    // Инициатор события (связь Many-to-One с User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiator_id", nullable = false)
    private User initiator;

    // Категория события (связь Many-to-One с Category)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Дата и время проведения события (обязательное)
    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate;

    // Количество подтвержденных заявок на участие
    @Column(name = "confirmed_requests")
    private int confirmedRequests;

    // Место проведения события (встраиваемый объект)
    @Embedded
    private Location location;

    // Флаг платности события
    @Column(name = "paid", nullable = false)
    private boolean paid;

    // Ограничение на количество участников
    @Column(name = "participant_limit")
    private int participantLimit;

    // Требуется ли премодерация заявок
    @Column(name = "request_moderation", nullable = false)
    private boolean requestModeration;

    // Статус события (PENDING, PUBLISHED, CANCELED)
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false, length = 20)
    private EventState state;

    // Дата и время создания события
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    // Дата и время публикации события
    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    // Причина модерации (например, почему событие отклонено)
    @Column(name = "moderation_resolution", length = 1000)
    private String moderationResolution;

}