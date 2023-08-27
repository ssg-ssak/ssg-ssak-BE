package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GiftPointRefuseInVo {
    private String receiverUUID;
    private LocalDateTime createAt;
}
