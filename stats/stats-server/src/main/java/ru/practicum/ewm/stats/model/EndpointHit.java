package ru.practicum.ewm.stats.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "id_gen", sequenceName = "hit_seq", allocationSize = 1)
@Table(name = "hits")
public class EndpointHit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long id;

    // Название приложения, от которого пришел запрос
    @Column(name = "app", nullable = false)
    private String app;

    // URI запрошенного ресурса
    @Column(name = "uri", nullable = false)
    private String uri;

    // IP-адрес пользователя
    @Column(name = "ip", nullable = false)
    private String ip;

    // Время создания записи о запросе
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}