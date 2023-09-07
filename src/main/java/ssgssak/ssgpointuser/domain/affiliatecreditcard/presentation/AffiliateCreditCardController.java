package ssgssak.ssgpointuser.domain.affiliatecreditcard.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.application.AffiliateCreditCardServiceImpl;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.dto.AffiliateCreditCardGetResponseDto;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.vo.AffiliateCreditCardGetOutVo;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.vo.AffiliateCreditCardRegisterInVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pointcard/credit")
public class AffiliateCreditCardController {
    private final AffiliateCreditCardServiceImpl affiliateCreditCardService;
    private final ModelMapper modelMapper;

    /**
     * 제휴 신용카드
     * 1. 카드 등록
     * 2. 카드 조회
     */

    //1. 카드 등록
    @PostMapping("")
    public void createCard(@RequestBody AffiliateCreditCardRegisterInVo inVo, Principal principal) {
        AffiliateCreditCardCreateRequestDto requestDto = modelMapper.map(inVo, AffiliateCreditCardCreateRequestDto.class);
        affiliateCreditCardService.createCard(requestDto, principal.getName());
    }

    //2. 카드 조회
    @GetMapping("")
    public ResponseEntity<AffiliateCreditCardGetOutVo> getCardList(Principal principal) {
        AffiliateCreditCardGetResponseDto responseDto = affiliateCreditCardService.getCardList(principal.getName());
        AffiliateCreditCardGetOutVo outVo = modelMapper.map(responseDto, AffiliateCreditCardGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
