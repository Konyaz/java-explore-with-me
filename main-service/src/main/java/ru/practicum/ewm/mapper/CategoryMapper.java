package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.practicum.ewm.dto.CategoryDataDto;
import ru.practicum.ewm.dto.CategoryDto;
import ru.practicum.ewm.model.Category;

// Преобразование между DTO и Entity для объектов Category
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Преобразование DTO создания в Entity для сохранения в БД
    Category toCategory(CategoryDataDto categoryDataDto);

    // Преобразование Entity в DTO (имеет имя для использования в других мапперах)
    @Named("toCategoryDto")
    CategoryDto toCategoryDto(Category category);

}