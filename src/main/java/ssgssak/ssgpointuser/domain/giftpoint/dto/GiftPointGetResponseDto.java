package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.*;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class GiftPointGetResponseDto {
    private String message;
    private String userUUID;
    private LocalDateTime updateAt;
}
