package ssgssak.ssgpointuser.domain.eventpoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.eventpoint.entity.AttendancePoint;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AttendancePointRepository extends JpaRepository<AttendancePoint, Long> {
}
