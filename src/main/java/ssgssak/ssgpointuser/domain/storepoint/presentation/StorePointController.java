package ssgssak.ssgpointuser.domain.storepoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.storepoint.application.StorePointServiceImpl;
import ssgssak.ssgpointuser.domain.storepoint.dto.StorePointAddDto;
import ssgssak.ssgpointuser.domain.storepoint.vo.StorePointAddInVo;

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
     */


    @PostMapping("/add")
    public void addStorePoint(@RequestBody StorePointAddInVo addInVo, Principal principal) {
        storePointService.addStorePoint(modelMapper.map(addInVo, StorePointAddDto.class), principal.getName());
    }

}
