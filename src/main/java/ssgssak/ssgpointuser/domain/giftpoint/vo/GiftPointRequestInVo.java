package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;

@Getter
public class GiftPointRequestInVo {
    private String giverUUID;
    private String receiverUUID;
    private String message;
}