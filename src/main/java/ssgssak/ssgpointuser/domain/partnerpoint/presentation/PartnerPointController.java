package ssgssak.ssgpointuser.domain.partnerpoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.partnerpoint.application.PartnerPointServiceImpl;
import ssgssak.ssgpointuser.domain.partnerpoint.dto.PartnerPointAddDto;
import ssgssak.ssgpointuser.domain.partnerpoint.vo.PartnerPointAddInVo;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partnerpoint")
public class PartnerPointController {

    private final PartnerPointServiceImpl partnerPointService;
    private final ModelMapper modelMapper;

    /**
     * 파트너 포인트
     * 1. 제휴 포인트 적립
     */

    @PostMapping("/add")
    public void addPartnerPoint(@RequestBody PartnerPointAddInVo addInVo, Principal principal) {
        partnerPointService.addPartnerPoint(modelMapper.map(addInVo, PartnerPointAddDto.class), principal.getName());
    }
}
