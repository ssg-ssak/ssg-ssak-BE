package ssgssak.ssgpointuser.domain.point.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

@Getter
public class PointAddInVo {
    private String uuid;
    private Integer updatePoint;
    private Boolean used;
    private PointType type;
}
