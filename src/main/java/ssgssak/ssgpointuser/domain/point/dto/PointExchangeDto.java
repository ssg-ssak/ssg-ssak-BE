package ssgssak.ssgpointuser.domain.point.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.point.entity.ExchangeType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PointExchangeDto {
    private ExchangeType type;  // 삼성, OK캐쉬백, 리워드360중 하나가 들어옴
    private Boolean used;       // ssg포인트를 얻는다면 false, ssg포인트를 잃는다면 true
    private Integer exchangePoint;
}
