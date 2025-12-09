package ru.practicum.ewm.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    // Идентификатор категории
    private int id;

    // Название категории
    private String name;
}