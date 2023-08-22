package ssgssak.ssgpointuser.domain.point.vo;

import lombok.Getter;
import lombok.ToString;
import ssgssak.ssgpointuser.domain.point.entity.GiftStatus;

@Getter
@ToString
public class PointGiftResponseInVo {
    private GiftStatus response;
    private Long giftPointId;
    private String uuid;
}
