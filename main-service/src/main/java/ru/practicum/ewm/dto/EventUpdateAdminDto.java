package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.practicum.ewm.model.EventStateAction;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventUpdateAdminDto {

    // Новый заголовок события (от 3 до 120 символов, необязательно)
    @Size(min = 3, max = 120)
    private String title;

    // Новое краткое описание (от 20 до 2000 символов, необязательно)
    @Size(min = 20, max = 2000)
    private String annotation;

    // Новое полное описание (от 20 до 7000 символов, необязательно)
    @Size(min = 20, max = 7000)
    private String description;

    // Новая дата и время события (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС, необязательно)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    // Новое ограничение на количество участников (неотрицательное, необязательно)
    @PositiveOrZero
    private Integer participantLimit;

    // Новая категория события (идентификатор, необязательно)
    private Integer category;

    // Новое место проведения события (необязательно)
    private LocationDto location;

    // Новый флаг платности события (необязательно)
    private Boolean paid;

    // Новый флаг премодерации заявок (необязательно)
    private Boolean requestModeration;

    // Действие администратора для изменения статуса события (необязательно)
    private EventStateAction stateAction;

    // Причина модерации (например, почему событие отклонено)
    private String moderationResolution;
}