package ssgssak.ssgpointuser.domain.point.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangeType;

@Getter
public class PointExchangeInVo {
    private String uuid;
    private ExchangeType type;  // 삼성, OK캐쉬백, 리워드360중 하나가 들어옴
    private Boolean used;       // ssg포인트를 얻는다면 false, ssg포인트를 잃는다면 true
    private Integer updatePoint;
}
