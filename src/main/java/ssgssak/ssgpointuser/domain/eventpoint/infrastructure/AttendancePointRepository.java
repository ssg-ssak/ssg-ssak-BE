package ssgssak.ssgpointuser.domain.eventpoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.eventpoint.entity.AttendancePoint;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AttendancePointRepository extends JpaRepository<AttendancePoint, Long> {
    /**
     * 출석체크 포인트
     * 1. 어제자 포인트 조회
     */

    // 1. 어제자 포인트 조회 : pointId와 어제 date, 오늘 date로 찾음
    Optional<AttendancePoint> findByPointIdAndCreateAtBetween(Long pointId, LocalDateTime stt, LocalDateTime end);
}
