package ssgssak.ssgpointuser.domain.exchangepoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.exchangepoint.application.ExchangePointServiceImpl;
import ssgssak.ssgpointuser.domain.exchangepoint.dto.ExchangeAddDto;
import ssgssak.ssgpointuser.domain.exchangepoint.vo.ExchangePointAddInVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class ExchangePointController {

    private final ExchangePointServiceImpl exchangePointService;
    private final ModelMapper modelMapper;

    /**
     * 1. 전환 포인트 적립
     * 2. 전환 포인트 조회 todo: 완성하기
     */

    // 1. 전환 포인트 적립
    @PostMapping("/add")
    public void addExchangePoint(@RequestBody ExchangePointAddInVo addInVo) {
        exchangePointService.pointAddExchange(modelMapper.map(addInVo, ExchangeAddDto.class), addInVo.getUuid());
    }
}
