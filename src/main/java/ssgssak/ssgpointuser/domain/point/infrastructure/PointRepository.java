package ssgssak.ssgpointuser.domain.point.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.point.entity.Point;
import ssgssak.ssgpointuser.domain.point.entity.PointType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    /**
     * 포인트
     * 1. 유저의 가장 최신 Point 조회
     * 2. 기간별, 전체 타입을, 전체 사용유무로 조회
     * 3. 기간별, 전체 타입을, 선택한 사용유무에 따라서 조회
     * 4. 기간별, 일반 타입(EVENT 제외)을, 전체 사용유무에 따라서 조회
     * 5. 기간별, 선택한 타입을, 전체 사용유무에 따라서 조회
     * 6. 기간별, 일반 타입(EVENT 제외)을, 선택한 사용유무에 따라서 조회
     * 7. 기간별, 선택한 타입을, 선택한 사용유무에 따라서 조회
     */

    // 1. 유저의 가장 최신 Point 조회
    Optional<Point> findFirstByUserUUIDOrderByCreateAtDesc(String uuid);

    // 2. 기간별, 전체 타입을, 전체 사용유무로 조회
    List<Point> findAllByUserUUIDAndCreateAtBetween(String uuid, LocalDateTime stt, LocalDateTime end);

    // 3. 기간별, 전체 타입을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndUsedAndCreateAtBetween(String uuid, Boolean used, LocalDateTime stt, LocalDateTime end);

    // 4. 기간별, 일반 타입(EVENT 제외)을, 전체 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndTypeNotAndCreateAtBetween(String uuid, PointType type, LocalDateTime stt, LocalDateTime end);

    // 5. 기간별, 선택한 타입을, 전체 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndTypeAndCreateAtBetween(String uuid, PointType type, LocalDateTime stt, LocalDateTime end);

    //6. 기간별, 일반 타입(EVENT 제외)을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndTypeNotAndUsedAndCreateAtBetween(String uuid, PointType type, Boolean used, LocalDateTime stt, LocalDateTime end);

    //7. 기간별, 선택한 타입을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndTypeAndUsedAndCreateAtBetween(String uuid, PointType type, Boolean used, LocalDateTime stt, LocalDateTime end);


}
