package ru.practicum.ewm.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestStatusUpdateResult {

    // Список подтвержденных заявок на участие
    @Builder.Default
    private List<ParticipationRequestDto> confirmedRequests = new ArrayList<>();

    // Список отклоненных заявок на участие
    @Builder.Default
    private List<ParticipationRequestDto> rejectedRequests = new ArrayList<>();

}