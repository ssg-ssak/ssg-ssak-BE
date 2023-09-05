package ssgssak.ssgpointuser.domain.eventpoint.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssgssak.ssgpointuser.domain.eventpoint.application.EventPointServiceImpl;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointGetResponseDto;
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
     * 3. 어제자 출석체크 포인트 조회
     */

    // 1. 출석체크 포인트 적립
    @PostMapping("/attendance")
    public void addAttendancePoint(@RequestBody AttendancePointAddInVo addInVo) {
        eventPointService.addAttendancePoint(modelMapper.map(addInVo, AttendancePointAddDto.class));
    }

    // 2. 룰렛 포인트 적립
    @PostMapping("/roulette")
    public void addRoulettePoint(@RequestBody RoulettePointAddInVo addInVo) {
        eventPointService.addRoulettePoint(modelMapper.map(addInVo, RoulettePointAddDto.class));
    }

    // 3. 어제자 출석체크 포인트 조회
    @GetMapping("/attendance")
    public ResponseEntity<AttendancePointGetOutVo> getAttendancePoint(@RequestParam Long pointId) {
        AttendancePointGetResponseDto responseDto = eventPointService.getYesterdayAttendancePoint(pointId);
        AttendancePointGetOutVo getOutVo = modelMapper.map(responseDto, AttendancePointGetOutVo.class);
        return new ResponseEntity<>(getOutVo, HttpStatus.OK);
    }
}
