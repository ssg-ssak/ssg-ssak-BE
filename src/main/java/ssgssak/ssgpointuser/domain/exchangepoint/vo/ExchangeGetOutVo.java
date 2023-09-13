package ssgssak.ssgpointuser.domain.exchangepoint.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeGetOutVo {
    private ExchangePoint exchangePoint;
}
