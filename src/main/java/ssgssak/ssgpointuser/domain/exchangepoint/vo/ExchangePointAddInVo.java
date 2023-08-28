package ssgssak.ssgpointuser.domain.exchangepoint.vo;

import lombok.Getter;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangeType;

@Getter
public class ExchangePointAddInVo {
    private ExchangeType type;  // 삼성, OK캐쉬백, 리워드360중 하나가 들어옴
    private String uuid;
    private Long pointId;
}
