package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GiftPointGetOutVo {
    private String message;
    private String userUUID;
    private LocalDateTime updateAt;
}
