package ru.practicum.ewm.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.dto.CompilationCreateDto;
import ru.practicum.ewm.dto.CompilationDto;
import ru.practicum.ewm.dto.CompilationUpdateDto;

import java.util.List;

public interface CompilationService {

    // Создание новой подборки событий
    CompilationDto addCompilation(CompilationCreateDto compilationCreateDto);

    // Удаление подборки по её идентификатору
    void removeCompilation(long comId);

    // Обновление информации о подборке
    CompilationDto updateCompilation(long compId, CompilationUpdateDto compilationUpdateDto);

    // Получение подборки по её идентификатору
    CompilationDto getCompilation(Long compId);

    // Получение списка подборок с фильтрацией по закреплению и пагинацией
    List<CompilationDto> getCompilations(Boolean pinned, Pageable pageable);
}