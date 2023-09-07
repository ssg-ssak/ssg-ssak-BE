package ssgssak.ssgpointuser.domain.affiliatepointcard.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.affiliatepointcard.application.AffiliatePointCardServiceImpl;
import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.dto.AffiliatePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;
import ssgssak.ssgpointuser.domain.affiliatepointcard.vo.AffiliatePointCardGetOutVo;
import ssgssak.ssgpointuser.domain.affiliatepointcard.vo.AffiliatePointCardRegisterInVo;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardRegisterRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.dto.OnlinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardCreateInVo;
import ssgssak.ssgpointuser.domain.onlinepointcard.vo.OnlinePointCardGetOutVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pointcard/affiliate")
public class AffiliatePointCardController {
    private final AffiliatePointCardServiceImpl affiliatePointCardService;
    private final ModelMapper modelMapper;

    /**
     * 제휴 포인트카드
     * 1. 카드 등록
     * 2. 카드 조회 : uuid와 type에 해당하는 카드 조회
     */

    //1. 카드 등록
    @PostMapping("")
    public void createCard(@RequestBody AffiliatePointCardRegisterInVo inVo, Principal principal) {
        AffiliatePointCardCreateRequestDto requestDto = modelMapper.map(inVo, AffiliatePointCardCreateRequestDto.class);
        affiliatePointCardService.registerCard(requestDto, principal.getName());
    }

    //2. 카드 조회
    @GetMapping("")
    public ResponseEntity<AffiliatePointCardGetOutVo> getCardList(@RequestParam AffiliatePointCardType type, Principal principal) {
        AffiliatePointCardGetResponseDto responseDto = affiliatePointCardService.getCard(type, principal.getName());
        AffiliatePointCardGetOutVo outVo = modelMapper.map(responseDto, AffiliatePointCardGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
