package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {

    // Список ошибок валидации (может быть null)
    private List<String> errors;

    // Сообщение об ошибке
    private String message;

    // Причина ошибки
    private String reason;

    // Статус ошибки (например, "BAD_REQUEST")
    private String status;

    // Время возникновения ошибки
    private LocalDateTime timestamp;

}