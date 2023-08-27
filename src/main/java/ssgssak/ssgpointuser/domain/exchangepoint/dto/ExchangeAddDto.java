package ssgssak.ssgpointuser.domain.exchangepoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangeType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExchangeAddDto {
    private ExchangeType type;  // 삼성, OK캐쉬백, 리워드360중 하나가 들어옴
    private String uuid;
    private Long pointId;
}
