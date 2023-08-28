package ssgssak.ssgpointuser.domain.giftpoint.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.giftpoint.application.GiftPointServiceImpl;
import ssgssak.ssgpointuser.domain.giftpoint.dto.*;
import ssgssak.ssgpointuser.domain.giftpoint.vo.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gift")
@Slf4j
public class GiftPointController {

    private final GiftPointServiceImpl giftPointService;
    private final ModelMapper modelMapper;

    /**
     * 선물 포인트 컨트롤러
     * 1. 포인트 선물하기
     * 2. 포인트 선물받기(수락)
     * 3. 포인트 선물받기(거절)
     * 4. 포인트 선물 대기리스트 조회
     * 5. 선물 포인트 조회
     */

    // 1. 포인트 선물하기
    @PostMapping("/request")
    public void giftPointRequest(@RequestBody GiftPointRequestInVo requestInVo) {
        giftPointService.giveGiftPoint(modelMapper.map(requestInVo, GiftPointRequestDto.class));
    }

    // 2. 포인트 선물받기(수락)
    @PutMapping("/accept")
    public void acceptGiftPoint(@RequestBody GiftPointAcceptInVo acceptInVo) {
        giftPointService.acceptGiftPoint(modelMapper.map(acceptInVo, GiftPointAcceptDto.class));
    }

    // 3. 포인트 선물받기(거절)
    @PutMapping("/refuse")
    public void refuseGiftPoint(@RequestBody GiftPointRefuseInVo refuseInVo) {
        giftPointService.refuseGiftPoint(modelMapper.map(refuseInVo, GiftPointRefuseDto.class));
    }

    // 4. 포인트 선물 대기리스트 조회
    @GetMapping("/wait-list")
    public ResponseEntity<GiftPointWaitListOutVo> getWaitList(@RequestParam String uuid) {
        GiftPointWaitListOutVo outVo = modelMapper.map(giftPointService.getGiftWaitList(uuid), GiftPointWaitListOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 5. 선물 포인트 조회
    @GetMapping("")
    public ResponseEntity<GiftPointGetOutVo> getGiftPoint(@RequestParam GiftPointGetInVo getInVo) {
        GiftPointGetResponseDto requestDto = giftPointService.getGiftList(modelMapper.map(getInVo, GiftPointGetRequestDto.class));
        GiftPointGetOutVo getOutVo = modelMapper.map(requestDto, GiftPointGetOutVo.class);
        return new ResponseEntity<>(getOutVo, HttpStatus.OK);
    }
}
