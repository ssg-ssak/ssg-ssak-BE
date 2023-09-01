package ssgssak.ssgpointuser.domain.eventpoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.eventpoint.application.EventPointServiceImpl;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.vo.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/eventpoint")
public class EventPointController {

    private final EventPointServiceImpl eventPointService;
    private final ModelMapper modelMapper;

    /**
     * 이벤트포인트
     * 1. 출석체크 포인트 적립
     * 2. 룰렛 포인트 적립
     */

    // 1. 출석체크 포인트 적립
    @PostMapping("/attendance/add")
    public void addAttendancePoint(@RequestBody AttendancePointAddInVo addInVo, Principal principal) {
        eventPointService.addAttendancePoint(modelMapper.map(addInVo, AttendancePointAddDto.class), principal.getName());
    }

    // 2. 룰렛 포인트 적립
    @PostMapping("/roulette/add")
    public void addRoulettePoint(@RequestBody RoulettePointAddInVo addInVo, Principal principal) {
        eventPointService.addRoulettePoint(modelMapper.map(addInVo, RoulettePointAddDto.class), principal.getName());
    }

}
