package ru.practicum.ewm.stats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewStatsDto {
    // Название приложения/сервиса
    private String app;

    // URI ресурса
    private String uri;

    // Количество просмотров
    private Long hits;
}