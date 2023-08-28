package ssgssak.ssgpointuser.domain.eventpoint.application;

import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;

import java.time.LocalDateTime;

public interface EventPointService {
    /**
     * 이벤트 포인트 적립
     * 1. 출석체크 포인트 적립
     * 2. 룰렛 포인트 적립
     * 3. 출석체크 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
     * 4. 룰렛 당일 중복확인 (오늘 날짜로 조회해서 있다면 중복이다)
     * 5. 출석체크 연속 확인하기 (어제부터 9일전까지 출석이 9번이라면, 오늘이 10번째임 -> 추가포인트 지급)
     */


    // 1. 출석체크 포인트 적립
    void addAttendancePoint(AttendancePointAddDto addDto, String uuid);

    // 2. 룰렛 포인트 적립
    void addRoulettePoint(RoulettePointAddDto addDto, String uuid);

    // 3. 출석체크 당일 중복확인
    TodayDuplDto attendanceCheckTodayDupl(Long pointId, LocalDateTime createAt);
}
