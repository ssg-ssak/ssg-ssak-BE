package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;
import lombok.ToString;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;

import java.time.LocalDateTime;

@Getter
@ToString
public class GiftPointAcceptInVo {
    private String receiverUUID;
    private LocalDateTime createAt;
    private Long givePointId;
    private Long receivePointId;
}


