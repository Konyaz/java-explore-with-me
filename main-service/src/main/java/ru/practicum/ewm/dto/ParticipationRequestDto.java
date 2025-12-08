package ru.practicum.ewm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto {

    // Идентификатор заявки на участие
    private Long id;

    // Идентификатор события
    private Long event;

    // Идентификатор пользователя, подавшего заявку
    private Long requester;

    // Статус заявки (PENDING, CONFIRMED, REJECTED, CANCELED)
    private String status;

    // Дата и время создания заявки (формат: ГГГГ-ММ-ДД ЧЧ:ММ:СС)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
}