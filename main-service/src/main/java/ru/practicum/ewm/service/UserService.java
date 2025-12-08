package ru.practicum.ewm.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.dto.UserCreateDto;
import ru.practicum.ewm.dto.UserDto;

import java.util.List;

public interface UserService {

    // Добавление нового пользователя
    UserDto addUser(UserCreateDto userCreateDto);

    // Удаление пользователя по его идентификатору
    void removeUser(long userId);

    // Получение списка пользователей с фильтрацией по ID и пагинацией
    List<UserDto> getUsers(List<Long> ids, Pageable pageable);
}