package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.practicum.ewm.dto.UserCreateDto;
import ru.practicum.ewm.dto.UserDto;
import ru.practicum.ewm.dto.UserShortDto;
import ru.practicum.ewm.model.User;

// Преобразование между DTO и Entity для объектов User
@Mapper(componentModel = "spring")
public interface UserMapper {

    // Преобразование DTO создания пользователя в Entity
    User toUser(UserCreateDto userCreateDto);

    // Преобразование Entity пользователя в полный DTO
    UserDto toUserDto(User user);

    // Преобразование Entity пользователя в краткий DTO (имеет имя для использования в других мапперах)
    @Named("toUserShortDto")
    UserShortDto toUserShortDto(User user);

}