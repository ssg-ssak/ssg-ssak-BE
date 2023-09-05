package ssgssak.ssgpointuser.domain.onlinepointcard.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.onlinepointcard.application.OnlinePointCardServiceImpl;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardCreateInVo;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardGetOutVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/online-p-card")
@Slf4j
public class OnlinePointCardController {
    private final OnlinePointCardServiceImpl onlinePointCardService;
    private final ModelMapper modelMapper;

    /**
     * 온라인 포인트카드
     * 1. 카드 등록
     * 2. 카드 조회
     */

    //1. 카드 등록
    @PostMapping("")
    public void createCard(@RequestBody OnlinePointCardCreateInVo inVo, Principal principal) {
        OnlinePointCardCreateRequestDto requestDto = modelMapper.map(inVo, OnlinePointCardCreateRequestDto.class);
        onlinePointCardService.createCard(requestDto, principal.getName());
    }

    //2. 카드 조회
    @GetMapping("")
    public ResponseEntity<OnlinePointCardGetOutVo> getCardList(Principal principal) {
        OnlinePointCardGetResponseDto responseDto = onlinePointCardService.getCardList(principal.getName());
        OnlinePointCardGetOutVo outVo = modelMapper.map(responseDto, OnlinePointCardGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
