package ru.practicum.ewm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {

    // Широта географической точки
    @Column(name = "lat")
    private Float lat;

    // Долгота географической точки
    @Column(name = "lon")
    private Float lon;

}