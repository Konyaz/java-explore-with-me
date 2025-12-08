package ru.practicum.ewm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewm.dto.CompilationDto;
import ru.practicum.ewm.model.Compilation;

// Преобразование между DTO и Entity для объектов Compilation
@Mapper(
        componentModel = "spring",
        uses = {EventMapper.class} // Используется EventMapper для преобразования событий
)
public interface CompilationMapper {

    // Преобразование Entity подборки в DTO, включая преобразование событий в краткий формат
    @Mapping(target = "events", qualifiedByName = "toEventShortDto")
    CompilationDto toCompilationDto(Compilation compilation);
}