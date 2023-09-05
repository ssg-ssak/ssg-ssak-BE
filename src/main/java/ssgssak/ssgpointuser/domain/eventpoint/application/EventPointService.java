package ssgssak.ssgpointuser.domain.eventpoint.application;

import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointGetResponseDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;

import java.time.LocalDateTime;

public interface EventPointService {
    /**
     * 이벤트 포인트 적립
     * 1. 출석체크 포인트 적립
     * 2. 룰렛 포인트 적립
     * 3. 어제자 출석체크 포인트 조회
     */


    // 1. 출석체크 포인트 적립
    void addAttendancePoint(AttendancePointAddDto addDto);

    // 2. 룰렛 포인트 적립
    void addRoulettePoint(RoulettePointAddDto addDto);

    // 3. 어제자 출석체크 포인트 조회
    AttendancePointGetResponseDto getYesterdayAttendancePoint(Long pointId);
}
