package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointListRequestDto {
    private PointType type;
    private Boolean used;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private Boolean isEvent;
}
