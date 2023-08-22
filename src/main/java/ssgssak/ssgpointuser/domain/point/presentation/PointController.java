package ssgssak.ssgpointuser.domain.point.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.point.application.PointServiceImpl;
import ssgssak.ssgpointuser.domain.point.dto.PointAddPartnerDto;
import ssgssak.ssgpointuser.domain.point.dto.PointAddStoreDto;
import ssgssak.ssgpointuser.domain.point.vo.PointAddPartnerInVo;
import ssgssak.ssgpointuser.domain.point.vo.PointAddStoreInVo;
import ssgssak.ssgpointuser.domain.point.vo.PointGiveInVo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/point")
public class PointController {

    private final PointServiceImpl pointService;
    private final ModelMapper modelMapper;


    /**
     * 포인트 컨트롤러
     * 1. 포인트 적립 - 스토어
     * 2. 포인트 적립 - 파트너
     * 3. 포인트 선물하기
     * 4. 포인트 선물받기
     */


    // 1. 포인트 적립 - 스토어
    @PostMapping("/add/store")
    public void addPointStore(@RequestBody PointAddStoreInVo pointAddStoreInVo) {
        PointAddStoreDto storeDto = modelMapper.map(pointAddStoreInVo, PointAddStoreDto.class);
        pointService.pointAddStore(storeDto, pointAddStoreInVo.getUuid());
    }

    // 2. 포인트 적립 - 파트너
    @PostMapping("/add/partner")
    public void addPointPartner(@RequestBody PointAddPartnerInVo pointAddPartnerInVo) {
        PointAddPartnerDto partnerDto = modelMapper.map(pointAddPartnerInVo, PointAddPartnerDto.class);
        pointService.pointAddPartner(partnerDto, pointAddPartnerInVo.getUuid());
    }


    // 3. 포인트 선물하기
    @PostMapping("/gift")
    public void givePoint(@RequestBody PointGiveInVo pointGiveInVo) {

    }
}
