package ru.practicum.ewm.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilationDto {

    // Идентификатор подборки
    private Long id;

    // Название подборки
    private String title;

    // Список событий в подборке
    private Set<EventShortDto> events;

    // Флаг закрепления подборки
    private Boolean pinned;
}