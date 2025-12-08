package ru.practicum.ewm.stats.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndpointHitDto {

    private Long id;

    // Название микросервиса, отправившего запрос (обязательное поле)
    @NotBlank
    private String app;

    // URI запрошенного ресурса (обязательное поле)
    @NotBlank
    private String uri;

    // IP-адрес пользователя, совершившего запрос (обязательное поле)
    @NotBlank
    private String ip;

    // Дата и время, когда был совершен запрос (обязательное поле, формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
}