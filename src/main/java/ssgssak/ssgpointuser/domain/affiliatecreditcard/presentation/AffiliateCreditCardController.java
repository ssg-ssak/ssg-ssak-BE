package ssgssak.ssgpointuser.domain.affiliatecreditcard.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardCreateInVo;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardGetOutVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pointcard/credit")
public class AffiliateCreditCardController {



//    /**
//     * 온라인 포인트카드
//     * 1. 카드 등록
//     * 2. 카드 조회
//     */
//
//    //1. 카드 등록
//    @PostMapping("")
//    public void createCard(@RequestBody OnlinePointCardCreateInVo inVo, Principal principal) {
//        OnlinePointCardCreateRequestDto requestDto = modelMapper.map(inVo, OnlinePointCardCreateRequestDto.class);
//        onlinePointCardService.createCard(requestDto, principal.getName());
//    }
//
//    //2. 카드 조회
//    @GetMapping("")
//    public ResponseEntity<OnlinePointCardGetOutVo> getCardList(Principal principal) {
//        OnlinePointCardGetResponseDto responseDto = onlinePointCardService.getCardList(principal.getName());
//        OnlinePointCardGetOutVo outVo = modelMapper.map(responseDto, OnlinePointCardGetOutVo.class);
//        return new ResponseEntity<>(outVo, HttpStatus.OK);
//    }
}
