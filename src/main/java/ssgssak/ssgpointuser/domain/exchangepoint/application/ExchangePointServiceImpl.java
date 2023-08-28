package ssgssak.ssgpointuser.domain.exchangepoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.exchangepoint.dto.ExchangeAddDto;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;
import ssgssak.ssgpointuser.domain.exchangepoint.infrastructure.ExchangePointRepository;

@Service
@RequiredArgsConstructor
public class ExchangePointServiceImpl implements ExchangePointService{

    private final ExchangePointRepository exchangePointRepository;
    private final ModelMapper modelMapper;

    /**
     * 전환 포인트
     * 1. 전환 포인트 생성
     * 2. 전환 포인트 적
     */

    // 1. 전환 포인트 생성
    @Override
    public ExchangePoint createExchangePoint(ExchangeAddDto addDto) {
        ExchangePoint exchangePoint = modelMapper.map(addDto, ExchangePoint.class);
        return exchangePoint;
    }

    // 2. 전환 적립
    @Override
    public void pointAddExchange(ExchangeAddDto addDto, String uuid) {
        exchangePointRepository.save(createExchangePoint(addDto));
    }
}
