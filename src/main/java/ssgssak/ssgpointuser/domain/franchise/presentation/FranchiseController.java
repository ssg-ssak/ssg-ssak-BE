package ssgssak.ssgpointuser.domain.franchise.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.franchise.application.FranchiseServiceImpl;
import ssgssak.ssgpointuser.domain.franchise.dto.FranchiseGetResponseDto;
import ssgssak.ssgpointuser.domain.franchise.vo.FranchiseGetOutVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/franchise")
public class FranchiseController {
    private final FranchiseServiceImpl franchiseService;
    private final ModelMapper modelMapper;

    /**
     * 가맹점
     * 1. 모든 가맹점 조회
     */

    // 1. 모든 가맹점 조회
    @GetMapping("")
    public ResponseEntity<FranchiseGetOutVo> getFranchise() {
        FranchiseGetResponseDto responseDto = franchiseService.getFranchise();
        FranchiseGetOutVo outVo = modelMapper.map(responseDto, FranchiseGetOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
