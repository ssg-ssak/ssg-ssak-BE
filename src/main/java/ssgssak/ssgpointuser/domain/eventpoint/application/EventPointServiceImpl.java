package ssgssak.ssgpointuser.domain.eventpoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointGetResponseDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.entity.AttendancePoint;
import ssgssak.ssgpointuser.domain.eventpoint.entity.RoulettePoint;
import ssgssak.ssgpointuser.domain.eventpoint.infrastructure.AttendancePointRepository;
import ssgssak.ssgpointuser.domain.eventpoint.infrastructure.RoulettePointReposiotry;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventPointServiceImpl implements EventPointService {
    private final AttendancePointRepository attendancePointRepository;
    private final RoulettePointReposiotry roulettePointReposiotry;
    private final ModelMapper modelMapper;

    /**
     * 이벤트 포인트 적립
     * 1. 출석체크 포인트 적립
     * 2. 룰렛 포인트 적립
     * 3. 어제자 출석체크 포인트 조회
    */

    // 1. 출석체크 포인트 적립
    @Override
    public void addAttendancePoint(AttendancePointAddDto addDto) {
        AttendancePoint attendancePoint = modelMapper.map(addDto, AttendancePoint.class);
        attendancePointRepository.save(attendancePoint);
    }

    // 2. 룰렛 포인트 적립
    @Override
    public void addRoulettePoint(RoulettePointAddDto addDto) {
        RoulettePoint roulettePoint = modelMapper.map(addDto, RoulettePoint.class);
        roulettePointReposiotry.save(roulettePoint);
    }

    // 3. 어제자 출석체크 포인트 조회
    @Override
    public AttendancePointGetResponseDto getYesterdayAttendancePoint(Long pointId) {
        LocalDateTime yesterday = LocalDate.now().minusDays(1).atStartOfDay();
        LocalDateTime today = LocalDate.now().atStartOfDay();
        // 포인트id, 어제, 오늘로 출석포인트를 조회
        Optional<AttendancePoint> attendancePoint = attendancePointRepository
                .findByPointIdAndCreateAtBetween(pointId, yesterday, today);
        // 출석포인트가 존재한다면 그대로 return
        AttendancePointGetResponseDto responseDto = AttendancePointGetResponseDto.builder().build();
        if (attendancePoint.isPresent() == true) {
            responseDto = AttendancePointGetResponseDto.builder().attendancePoint(attendancePoint.get()).build();
        }
        return responseDto;
    }
}
