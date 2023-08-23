package ssgssak.ssgpointuser.domain.point.dto;

import lombok.*;
import ssgssak.ssgpointuser.domain.point.entity.GiftStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PointGiftResponseDto {
    private GiftStatus response;
    private Long giftPointId;
    private String uuid;
}
