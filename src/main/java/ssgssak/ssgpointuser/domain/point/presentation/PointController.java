package ssgssak.ssgpointuser.domain.point.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.point.application.PointServiceImpl;
import ssgssak.ssgpointuser.domain.point.dto.*;
import ssgssak.ssgpointuser.domain.point.vo.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
@Slf4j
public class PointController {

    private final PointServiceImpl pointService;
    private final ModelMapper modelMapper;


    /**
     * 포인트 컨트롤러
     * 1. 포인트 적립 - 스토어
     * 2. 포인트 적립 - 파트너
     * 3. 포인트 선물하기
     * 4. 포인트 선물받기
     * 5. 포인트 선물 대기리스트 조회
     * 6. 포인트 전환하기
     */


    // 1. 포인트 적립 - 스토어
    @PostMapping("/add/store")
    public void addPointStore(@RequestBody PointAddStoreInVo pointAddStoreInVo) {
        PointAddStoreDto storeDto = modelMapper.map(pointAddStoreInVo, PointAddStoreDto.class);
        pointService.pointAddStore(storeDto, pointAddStoreInVo.getUuid());
    }

    // 2. 포인트 적립 - 파트너
    @PostMapping("/add/partner")
    public void addPointPartner(@RequestBody PointAddPartnerInVo pointAddPartnerInVo) {
        PointAddPartnerDto partnerDto = modelMapper.map(pointAddPartnerInVo, PointAddPartnerDto.class);
        pointService.pointAddPartner(partnerDto, pointAddPartnerInVo.getUuid());
    }


    // 3. 포인트 선물하기
    @PostMapping("/gift/give")
    public void givePoint(@RequestBody PointGiftRequestInVo pointGiftRequestInVo) {
        PointGiftRequestDto giftDto = modelMapper.map(pointGiftRequestInVo, PointGiftRequestDto.class);
        pointService.giveGiftPoint(giftDto);
    }

    // 4. 포인트 선물받기 : receiver의 uuid와 success=false인 giftpoint를 검색하면 된다
    @PostMapping("/gift/receive")
    public void receivePoint(@RequestBody PointGiftResponseInVo pointGiftResponseInVo) {
        log.info("들어온값 : " + pointGiftResponseInVo);
        PointGiftResponseDto responseDto = modelMapper.map(pointGiftResponseInVo, PointGiftResponseDto.class);
        pointService.receiveGiftPoint(responseDto);
    }

    // 5. 포인트 선물 대기 리스트 조회
    @GetMapping("/gift/wait-list")
    public ResponseEntity<PointGiftWaitListDto> waitList(@RequestParam String uuid) {
        PointGiftWaitListDto waitList = pointService.getGiftWaitList(uuid);
        return new ResponseEntity<>(waitList, HttpStatus.OK);
    }

    // 6. 포인트 전환하기
    @PostMapping("/exchange")
    public void exchangePoint(@RequestBody PointExchangeInVo pointExchangeInVo) {
        PointExchangeDto exchangeDto = modelMapper.map(pointExchangeInVo, PointExchangeDto.class);
        pointService.pointExchange(exchangeDto, pointExchangeInVo.getUuid());
    }
}
