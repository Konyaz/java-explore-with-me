package ru.practicum.ewm.stats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.ewm.stats.dto.ViewStatsDto;
import ru.practicum.ewm.stats.model.EndpointHit;

import java.time.LocalDateTime;
import java.util.List;


public interface StatsRepository extends JpaRepository<EndpointHit, Long> {

    // Получение уникальной статистики (по уникальным IP) за период без фильтрации по URI
    @Query("""
            SELECT new ru.practicum.ewm.stats.dto.ViewStatsDto(h.app, h.uri, COUNT(DISTINCT h.ip))
              FROM EndpointHit h
             WHERE h.timestamp BETWEEN :start AND :end
             GROUP BY h.app, h.uri
             ORDER BY COUNT(DISTINCT h.ip) DESC
            """)
    List<ViewStatsDto> getUniqueStats(@Param("start") LocalDateTime start,
                                      @Param("end") LocalDateTime end);

    // Получение неуникальной статистики (все просмотры) за период без фильтрации по URI
    @Query("""
            SELECT new ru.practicum.ewm.stats.dto.ViewStatsDto(h.app, h.uri, COUNT(h))
              FROM EndpointHit h
             WHERE h.timestamp BETWEEN :start AND :end
             GROUP BY h.app, h.uri
             ORDER BY COUNT(h) DESC
            """)
    List<ViewStatsDto> getNotUniqueStats(@Param("start") LocalDateTime start,
                                         @Param("end") LocalDateTime end);

    // Получение уникальной статистики (по уникальным IP) за период с фильтрацией по URI
    @Query(value = """
            SELECT new ru.practicum.ewm.stats.dto.ViewStatsDto(h.app, h.uri, COUNT(DISTINCT h.ip))
              FROM EndpointHit h
             WHERE h.timestamp BETWEEN :start AND :end
               AND h.uri IN :uris
             GROUP BY h.app, h.uri
             ORDER BY COUNT(DISTINCT h.ip) DESC
            """)
    List<ViewStatsDto> getUniqueStatsForUris(@Param("start") LocalDateTime start,
                                             @Param("end") LocalDateTime end,
                                             @Param("uris") List<String> uris);

    // Получение неуникальной статистики (все просмотры) за период с фильтрацией по URI
    @Query("""
            SELECT new ru.practicum.ewm.stats.dto.ViewStatsDto(h.app, h.uri, COUNT(h))
              FROM EndpointHit h
             WHERE h.timestamp BETWEEN :start AND :end
               AND h.uri IN :uris
             GROUP BY h.app, h.uri
             ORDER BY COUNT(h) DESC
            """)
    List<ViewStatsDto> getNotUniqueStatsForUris(@Param("start") LocalDateTime start,
                                                @Param("end") LocalDateTime end,
                                                @Param("uris") List<String> uris);
}