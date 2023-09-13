package ssgssak.ssgpointuser.domain.exchangepoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.exchangepoint.dto.ExchangeAddDto;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;
import ssgssak.ssgpointuser.domain.exchangepoint.infrastructure.ExchangePointRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ExchangePointServiceImpl implements ExchangePointService{

    private final ExchangePointRepository exchangePointRepository;
    private final ModelMapper modelMapper;

    /**
     * 전환 포인트
     * 1. 전환 포인트 생성
     * 2. 전환 포인트 적립
     * 3. pointId로 조회
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

    // 3. 포인트id로 조회
    @Override
    public ExchangePoint getExchangePoint(Long pointId) {
        ExchangePoint exchangePoint = exchangePointRepository.findByPointId(pointId)
                .orElseThrow(() -> new NoSuchElementException());
        return exchangePoint;
    }
}
