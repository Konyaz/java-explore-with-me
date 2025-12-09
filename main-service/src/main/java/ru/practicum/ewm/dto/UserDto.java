package ru.practicum.ewm.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    // Идентификатор пользователя
    private long id;

    // Email пользователя
    private String email;

    // Имя пользователя
    private String name;
}