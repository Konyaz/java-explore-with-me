package ru.practicum.ewm.dto;

import lombok.*;
import ru.practicum.ewm.model.RequestStatus;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestStatusUpdateDto {

    // Список идентификаторов заявок для обновления статуса
    private List<Long> requestIds;

    // Новый статус для заявок (CONFIRMED или REJECTED)
    private RequestStatus status;

}