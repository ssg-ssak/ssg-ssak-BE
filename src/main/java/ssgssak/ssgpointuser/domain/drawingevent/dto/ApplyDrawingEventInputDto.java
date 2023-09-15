package ssgssak.ssgpointuser.domain.drawingevent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyDrawingEventInputDto {
    private Long drawingEventId;
}