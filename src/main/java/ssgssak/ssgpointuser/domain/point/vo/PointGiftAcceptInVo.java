package ssgssak.ssgpointuser.domain.point.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

@Getter
public class PointGiftAcceptInVo {
    private String receiverUUID;
    private String giverUUID;
    private Integer updatePoint;
}
