package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.*;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GiftPointAcceptRequestDto {
    private String receiverUUID;
    private Long giftPointId;
    private Long givePointId;
    private Long receivePointId;
}
