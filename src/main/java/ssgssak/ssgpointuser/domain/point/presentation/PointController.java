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
     * 3. 포인트 선물받기
     * 4. 포인트 전환하기
     * 5. 포인트 기간별로 조회하기
     * 6. 사용가능 포인트 조회
     */


    // 1. 포인트 적립 - 스토어 -> 진행이후 스토어포인트에 POST, "/storepoint/add"로 요청이 들어가는것까지가 한세트임
    @PostMapping("/add/store")
    public void addPointStore(@RequestBody PointAddInVo addInVo) {
        pointService.pointAddStore(modelMapper.map(addInVo, CreatePointDto.class), addInVo.getUuid());
    }

    // 2. 포인트 적립 - 파트너 -> 진행이후 파트너포인트에 POST, "/partnerpoint/add"로 요청이 들어가는것까지가 한세트임
    @PostMapping("/add/partner")
    public void addPointPartner(@RequestBody PointAddPartnerInVo addInVo){
        pointService.pointAddPartner(modelMapper.map(addInVo, CreatePointDto.class), addInVo.getUuid());
    }

    // 3. 포인트 선물받기 -> 진행이후 선물포인트에 POST, "/gift/accept"로 요청이 들어가는것가지가 한세트임
    @PostMapping("/gift/receive")
    public ResponseEntity<PointGiftAcceptOutVo> receivePoint(@RequestBody PointGiftAcceptInVo inVo) {
        PointGiftAcceptResponseDto responseDto = pointService.receiveGiftPoint(
                modelMapper.map(inVo, PointGiftAcceptRequestDto.class));
        PointGiftAcceptOutVo outVo = modelMapper.map(responseDto, PointGiftAcceptOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 4. 포인트 전환하기 -> 진행이후 전환포인트에 POST, "/exchangepoint/add"로 요청이 들어가는것까지가 한세트임
    @PostMapping("/exchange")
    public void exchangePoint(@RequestBody PointExchangeInVo pointExchangeInVo) {
        pointService.pointExchange(modelMapper.map(pointExchangeInVo, CreatePointDto.class), pointExchangeInVo.getUuid());
    }

    // 5. 포인트 기간별로 조회하기
    @GetMapping("/list") // todo: vo로 받아오기
    public ResponseEntity<PointListOutVo> searchPointList(PointListInVo inVo) {
        PointListRequestDto requestDto = modelMapper.map(inVo, PointListRequestDto.class);
        PointListResponseDto responseDto = pointService.pointSearch(requestDto,inVo.getUuid());
        PointListOutVo outVo = modelMapper.map(responseDto, PointListOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 6. 사용 가능 포인트 조회
    @GetMapping("/possible")
    public ResponseEntity<PointPossibleOutVo> searchPossiblePoint(@RequestParam String uuid) {
        PointPossibleResponseDto responseDto = pointService.searchPossible(uuid);
        PointPossibleOutVo outVo = modelMapper.map(responseDto, PointPossibleOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
