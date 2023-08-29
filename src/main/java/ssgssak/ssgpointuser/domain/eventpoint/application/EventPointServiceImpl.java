package ssgssak.ssgpointuser.domain.eventpoint.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.eventpoint.dto.AttendancePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.dto.RoulettePointAddDto;
import ssgssak.ssgpointuser.domain.eventpoint.entity.AttendancePoint;
import ssgssak.ssgpointuser.domain.eventpoint.entity.RoulettePoint;
import ssgssak.ssgpointuser.domain.eventpoint.infrastructure.AttendancePointRepository;
import ssgssak.ssgpointuser.domain.eventpoint.infrastructure.RoulettePointReposiotry;

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
    */

    // 1. 출석체크 포인트 적립
    @Override
    public void addAttendancePoint(AttendancePointAddDto addDto, String uuid) {
        AttendancePoint attendancePoint = modelMapper.map(addDto, AttendancePoint.class);
        attendancePointRepository.save(attendancePoint);
    }

    // 2. 룰렛 포인트 적립
    @Override
    public void addRoulettePoint(RoulettePointAddDto addDto, String uuid) {
        RoulettePoint roulettePoint = modelMapper.map(addDto, RoulettePoint.class);
        roulettePointReposiotry.save(roulettePoint);
    }
}
