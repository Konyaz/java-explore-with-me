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
        sequenceName = "req_seq",
        allocationSize = 1)
@Table(name = "requests")
public class ParticipationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long id;

    // Событие, на которое подана заявка (связь Many-to-One с Event)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    // Пользователь, подавший заявку (связь Many-to-One с User)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    // Статус заявки (PENDING, CONFIRMED, REJECTED, CANCELED)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private RequestStatus status;

    // Дата и время создания заявки
    @Column(name = "created")
    private LocalDateTime created;

}