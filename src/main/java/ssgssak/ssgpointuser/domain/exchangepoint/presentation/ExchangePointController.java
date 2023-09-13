package ssgssak.ssgpointuser.domain.exchangepoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.exchangepoint.application.ExchangePointServiceImpl;
import ssgssak.ssgpointuser.domain.exchangepoint.dto.ExchangeAddDto;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;
import ssgssak.ssgpointuser.domain.exchangepoint.vo.ExchangeGetOutVo;
import ssgssak.ssgpointuser.domain.exchangepoint.vo.ExchangePointAddInVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchangepoint")
public class ExchangePointController {

    private final ExchangePointServiceImpl exchangePointService;
    private final ModelMapper modelMapper;

    /**
     * 1. 전환 포인트 적립
     * 2. 전환 포인트 조회 todo: 완성하기
     */

    // 1. 전환 포인트 적립
    @PostMapping("")
    public void addExchangePoint(@RequestBody ExchangePointAddInVo addInVo, Principal principal) {
        exchangePointService.pointAddExchange(modelMapper.map(addInVo, ExchangeAddDto.class), principal.getName());
    }

    // 2. 전환 포인트 조회
    @GetMapping("")
    public ResponseEntity<ExchangeGetOutVo> getExchangePoint(@RequestParam Long pointId) {
        ExchangePoint ePoint = exchangePointService.getExchangePoint(pointId);
        ExchangeGetOutVo outVo = ExchangeGetOutVo.builder().exchangePoint(ePoint).build();
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
