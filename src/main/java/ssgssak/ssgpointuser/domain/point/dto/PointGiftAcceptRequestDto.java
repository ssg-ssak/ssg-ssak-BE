package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointGiftAcceptRequestDto {
    private String receiverUUID;
    private String giverUUID;
    private Integer updatePoint;
    private PointType type = PointType.GIFT;
}
