package ru.practicum.ewm.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto {
    // Идентификатор пользователя
    private long id;

    // Имя пользователя
    private String name;
}