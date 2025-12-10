package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventPublicFullDto {

    // Идентификатор события
    private long id;

    // Заголовок события
    private String title;

    // Краткое описание события
    private String annotation;

    // Полное описание события
    private String description;

    // Инициатор события
    private UserShortDto initiator;

    // Категория события
    private CategoryDto category;

    // Место проведения события
    private LocationDto location;

    // Флаг платности события
    private boolean paid;

    // Ограничение на количество участников
    private int participantLimit;

    // Требуется ли премодерация заявок
    private boolean requestModeration;

    // Количество подтвержденных заявок на участие
    private Long confirmedRequests;

    // Количество просмотров события
    private Long views;

    // Статус события (PENDING, PUBLISHED, CANCELED)
    private String state;

    // Дата и время проведения события (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    // Дата и время создания события (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdOn;

    // Дата и время публикации события (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedOn;

}