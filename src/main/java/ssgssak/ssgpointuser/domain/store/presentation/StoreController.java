package ssgssak.ssgpointuser.domain.store.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.store.application.StoreServiceImpl;
import ssgssak.ssgpointuser.domain.store.dto.StoreGetRegionRequestDto;
import ssgssak.ssgpointuser.domain.store.dto.StoreGetRegionResponseDto;
import ssgssak.ssgpointuser.domain.store.vo.StoreGetRegionInVo;
import ssgssak.ssgpointuser.domain.store.vo.StoreGetRegionOutVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreServiceImpl storeService;
    private final ModelMapper modelMapper;

    /**
     * 제휴 매장 & 단골매장
     * 1. 매장 지도로 검색하기
     * 2. 매장 지역으로 검색하기
     * 3. 단골매장 등록하기
     */

    // 1. 매장 지도로 검색하기 : 지도에 표시되는 위-경도의 경곗값을 전달받아서, 그 사이에 존재하는 매장만 넘겨줌


    // 2. 매장 지역으로 검색하기 : 제휴사,시,군(구)를 넘겨받아서, 그 사이에 존재하는 매장만 넘겨줌
    @GetMapping("/region")
    public ResponseEntity<StoreGetRegionOutVo> getByRegion(StoreGetRegionInVo inVo) {
        StoreGetRegionResponseDto responseDto = storeService.getByRegion(modelMapper.map(inVo, StoreGetRegionRequestDto.class));
        StoreGetRegionOutVo outVo = modelMapper.map(responseDto, StoreGetRegionOutVo.class);
        return new ResponseEntity<>(outVo, HttpStatus.OK);
    }

    // 3. 단골매장 등록하기 : 매장 id값과 uuid를 넘겨받아서 진행, store_id가 아닌 store 전체를 저장하는것임






}
