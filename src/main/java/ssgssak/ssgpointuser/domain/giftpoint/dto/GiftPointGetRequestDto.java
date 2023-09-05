package ssgssak.ssgpointuser.domain.giftpoint.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GiftPointGetRequestDto {
    private Boolean used;
    private Long pointId; // used == true라면 pointId는 givePointId, used==false라면 uuid는 receivePointId
}
