package ru.practicum.ewm.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Поиск пользователя по email
    Optional<User> findByEmail(String email);

    // Получение списка пользователей по списку ID с пагинацией
    List<User> findAllByIdIn(List<Long> ids, Pageable pageable);

}