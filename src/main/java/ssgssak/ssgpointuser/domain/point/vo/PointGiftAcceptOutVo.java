package ssgssak.ssgpointuser.domain.point.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointGiftAcceptOutVo {
    private Long givePointId;
    private Long receivePointId;
}
