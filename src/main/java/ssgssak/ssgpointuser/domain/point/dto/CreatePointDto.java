package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreatePointDto {
    private Integer totalPoint;
    private Integer updatePoint;
    private Boolean used;
    private PointType type;
    private String uuid;
}
