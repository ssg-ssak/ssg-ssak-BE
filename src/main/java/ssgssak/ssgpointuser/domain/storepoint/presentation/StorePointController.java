package ssgssak.ssgpointuser.domain.storepoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.storepoint.application.StorePointServiceImpl;
import ssgssak.ssgpointuser.domain.storepoint.dto.StorePointAddDto;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;
import ssgssak.ssgpointuser.domain.storepoint.vo.StorePointAddInVo;
import ssgssak.ssgpointuser.domain.storepoint.vo.StorePointGetOutVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/storepoint")
public class StorePointController {

    private final StorePointServiceImpl storePointService;
    private final ModelMapper modelMapper;

    /**
     * 스토어포인트
     * 1. 스토어 포인트 적립
     * 2. id로 조회
     */


    // 1. 스토어 포인트 적립
    @PostMapping("/add")
    public void addStorePoint(@RequestBody StorePointAddInVo addInVo, Principal principal) {
        storePointService.addStorePoint(modelMapper.map(addInVo, StorePointAddDto.class), principal.getName());
    }

    // 2. id로 조회
    @GetMapping("/point-id")
    public ResponseEntity<StorePointGetOutVo> getStorePoint(@RequestParam Long pointId) {
        StorePoint storePoint = storePointService.getStorePoint(pointId);
        StorePointGetOutVo outVo = StorePointGetOutVo.builder().storePoint(storePoint).build();
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }
}
