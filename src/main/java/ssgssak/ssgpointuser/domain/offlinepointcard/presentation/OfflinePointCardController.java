package ssgssak.ssgpointuser.domain.offlinepointcard.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.offlinepointcard.application.OfflinePointCardServiceImpl;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardCreateRequestDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardGetResponseDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.dto.OfflinePointCardRegisterRequestDto;
import ssgssak.ssgpointuser.domain.offlinepointcard.vo.OfflinePointCardCreateInVo;
import ssgssak.ssgpointuser.domain.offlinepointcard.vo.OfflinePointCardGetOutVo;
import ssgssak.ssgpointuser.domain.offlinepointcard.vo.OfflinePointCardRegisterInVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pointcard/offline")
public class OfflinePointCardController {
    private final OfflinePointCardServiceImpl offlinePointCardService;
    private final ModelMapper modelMapper;

    /**
     * 오프라인 포인트카드
     * 1. 오프라인카드 신규카드 등록(create)
     * 2. 오프라인카드 임시 발급(create)
     * 3. 오프라인카드 최종 등록(update)
     * 4. 오프라인카드 조회
     */

    //1. 오프라인카드 신규카드 등록(create) -> uuid를 넘겨줌
    @PostMapping("/new")
    public void createNewCard(@RequestBody OfflinePointCardCreateInVo inVo, Principal principal) {
        OfflinePointCardCreateRequestDto requestDto = modelMapper.map(inVo, OfflinePointCardCreateRequestDto.class);
        offlinePointCardService.createCard(requestDto, principal.getName());
    }

    //2. 오프라인카드 임시 발급(create) -> uuid를 넘겨주지 않음, 따라서 filter를 거치지 않아야함
    @PostMapping("/temp")
    public void createTempCard(@RequestBody OfflinePointCardCreateInVo inVo) {
        OfflinePointCardCreateRequestDto requestDto = modelMapper.map(inVo, OfflinePointCardCreateRequestDto.class);
        offlinePointCardService.createCard(requestDto);
    }

    //3. 오프라인카드 최종 등록(update)
    @PutMapping("")
    public void updateCard(@RequestBody OfflinePointCardRegisterInVo inVo, Principal principal) {
        OfflinePointCardRegisterRequestDto requestDto = modelMapper.map(inVo, OfflinePointCardRegisterRequestDto.class);
        offlinePointCardService.registerCard(requestDto, principal.getName());
    }

    //4. 카드 조회
    @GetMapping("")
    public ResponseEntity<OfflinePointCardGetOutVo> getCardList(Principal principal) {
        OfflinePointCardGetResponseDto responseDto = offlinePointCardService.getCardList(principal.getName());
        OfflinePointCardGetOutVo outVo = modelMapper.map(responseDto, OfflinePointCardGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
