package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventShortDto {

    // Идентификатор события
    private long id;

    // Заголовок события
    private String title;

    // Краткое описание события
    private String annotation;

    // Инициатор события (краткая информация)
    private UserShortDto initiator;

    // Категория события
    private CategoryDto category;

    // Флаг платности события
    private boolean paid;

    // Количество подтвержденных заявок на участие
    private Long confirmedRequests;

    // Количество просмотров события
    private Long views;

    // Дата и время проведения события (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

}