package ru.practicum.ewm.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    // Широта географической точки (обязательное поле)
    @NotNull
    private Float lat;

    // Долгота географической точки (обязательное поле)
    @NotNull
    private Float lon;

}