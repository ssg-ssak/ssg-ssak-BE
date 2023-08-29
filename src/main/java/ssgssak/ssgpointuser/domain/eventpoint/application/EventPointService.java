package ssgssak.ssgpointuser.domain.eventpoint.application;

import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;

import java.time.LocalDateTime;

public interface EventPointService {
    /**
     * 이벤트 포인트 적립
     * 1. 출석체크 포인트 적립
     * 2. 룰렛 포인트 적립
     */


    // 1. 출석체크 포인트 적립
    void addAttendancePoint(AttendancePointAddDto addDto, String uuid);

    // 2. 룰렛 포인트 적립
    void addRoulettePoint(RoulettePointAddDto addDto, String uuid);
}
