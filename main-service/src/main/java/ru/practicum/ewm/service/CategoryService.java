package ru.practicum.ewm.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.dto.CategoryDataDto;
import ru.practicum.ewm.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    // Добавление новой категории
    CategoryDto addCategory(CategoryDataDto categoryDataDto);

    // Удаление категории по её идентификатору
    void removeCategory(int catId);

    // Обновление информации о категории
    CategoryDto updateCategory(int catId, CategoryDataDto categoryDataDto);

    // Получение списка всех категорий с пагинацией
    List<CategoryDto> getCategories(Pageable pageable);

    // Получение информации о конкретной категории по её идентификатору
    CategoryDto getCategory(int catId);

}