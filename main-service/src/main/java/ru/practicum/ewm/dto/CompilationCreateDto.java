package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompilationCreateDto {

    // Название подборки (обязательное, от 1 до 50 символов)
    @NotBlank
    @Size(min = 1, max = 50)
    private String title;

    // Список идентификаторов событий для включения в подборку
    private Set<Long> events;

    // Флаг закрепления подборки на главной странице (по умолчанию false)
    @Builder.Default
    private Boolean pinned = false;

}