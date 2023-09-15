package ssgssak.ssgpointuser.domain.drawingevent.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.drawingevent.entity.DrawingEvent;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDrawingEventOutputVo {
    private DrawingEvent drawingEvent;
}
