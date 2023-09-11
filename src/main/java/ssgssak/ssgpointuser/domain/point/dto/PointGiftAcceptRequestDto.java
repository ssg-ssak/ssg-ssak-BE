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
    private String giverUUID;
    private Integer updatePoint;

    @Builder.Default // @Default 어노테이션을 사용하지 않으면, 필드 초기화 구문이 무시되기때문에 사용해준다
    private PointType type = PointType.GIFT;
}
