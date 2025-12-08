package ru.practicum.ewm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateDto {

    // Email пользователя (обязательное, от 6 до 254 символов, валидный формат email)
    @NotBlank
    @Size(min = 6, max = 254)
    @Email
    private String email;

    // Имя пользователя (обязательное, от 2 до 250 символов)
    @NotBlank
    @Size(min = 2, max = 250)
    private String name;
}