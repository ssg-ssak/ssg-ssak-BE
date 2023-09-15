package ssgssak.ssgpointuser.domain.drawingevent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.drawingevent.entity.DrawingEvent;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDrawingEventOutputDto {
    private DrawingEvent drawingEvent;
}
