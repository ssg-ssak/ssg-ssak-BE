package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.*;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;

import java.time.LocalDateTime;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GiftPointAcceptDto {
    private String receiverUUID;
    private LocalDateTime createAt;
    private Long givePointId;
    private Long receivePointId;
}
