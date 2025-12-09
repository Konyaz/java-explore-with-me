package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventCreateDto {

    // Заголовок события (обязательное, от 3 до 120 символов)
    @NotBlank
    @Size(min = 3, max = 120)
    private String title;

    // Краткое описание события (обязательное, от 20 до 2000 символов)
    @NotBlank
    @Size(min = 20, max = 2000)
    private String annotation;

    // Полное описание события (обязательное, от 20 до 7000 символов)
    @NotBlank
    @Size(min = 20, max = 7000)
    private String description;

    // Идентификатор категории события (обязательное)
    @NotNull
    private Integer category;

    // Дата и время события (обязательное, не может быть в прошлом)
    @NotNull
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;

    // Место проведения события (обязательное)
    @NotNull
    private LocationDto location;

    // Флаг платности события (по умолчанию false)
    @Builder.Default
    private boolean paid = false;

    // Ограничение на количество участников (по умолчанию 0 - без ограничений)
    @Builder.Default
    @PositiveOrZero
    private int participantLimit = 0;

    // Требуется ли премодерация заявок на участие (по умолчанию true)
    @Builder.Default
    private boolean requestModeration = true;

}