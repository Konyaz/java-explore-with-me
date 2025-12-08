package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDataDto {

    // Название категории (обязательное, максимум 50 символов)
    @NotBlank
    @Size(max = 50)
    private String name;

}