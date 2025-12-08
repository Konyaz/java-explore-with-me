package ru.practicum.ewm.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompilationUpdateDto {

    // Новое название подборки (максимум 50 символов, необязательно)
    @Size(max = 50)
    private String title;

    // Обновленный список идентификаторов событий (необязательно)
    private Set<Long> events;

    // Новый статус закрепления подборки (необязательно)
    private Boolean pinned;

}