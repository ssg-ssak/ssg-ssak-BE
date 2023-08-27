package ssgssak.ssgpointuser.domain.exchangepoint.application;

import ssgssak.ssgpointuser.domain.exchangepoint.dto.ExchangeAddDto;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;

public interface ExchangePointService {

    // 1. 전환 포인트 생성
    ExchangePoint createExchangePoint(ExchangeAddDto addDto);

    // 2. 전환 적립
    void pointAddExchange(ExchangeAddDto addDto, String uuid);
}
