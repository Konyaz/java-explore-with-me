package ru.practicum.ewm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.ewm.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    // Поиск категории по названию (для проверки уникальности)
    Optional<Category> findByName(String name);

}