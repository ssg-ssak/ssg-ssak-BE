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
     * 8. 기간없이, 선물 포인트만, 사용 유무에 관계없이 조회
     * 9. 기간없이, 선물 포인트만, 사용 유무에 따라서 조회
     * 10. 하루종일, 이벤트타입에 따른 중복체크 조회
     * 11. 어제의, 출석체크포인트를 검색
     */

    // 1. 유저의 가장 최신 Point 조회 todo: findTop 을 쓰면 된다는데 first랑 top의 차이를 알아봐야겠음, findTopBy~
    Optional<Point> findFirstByUserUUIDOrderByCreateAtDesc(String uuid);

    // 2. 기간별, 전체 타입을, 전체 사용유무로 조회
    List<Point> findAllByUserUUIDAndCreateAtBetween(String uuid, LocalDateTime stt, LocalDateTime end);

    // 3. 기간별, 전체 타입을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndUsedAndCreateAtBetween(String uuid, Boolean used, LocalDateTime stt, LocalDateTime end);

    // 4. 기간별, 일반 타입(EVENT 제외)을, 전체 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndIsEventFalseAndCreateAtBetween(String uuid, LocalDateTime stt, LocalDateTime end);

    // 5. 기간별, 이벤트 타입을, 전체 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndIsEventTrueAndCreateAtBetween(String uuid, LocalDateTime stt, LocalDateTime end);

    //6. 기간별, 일반 타입(EVENT 제외)을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndIsEventFalseAndUsedAndCreateAtBetween(String uuid, Boolean used, LocalDateTime stt, LocalDateTime end);

    //7. 기간별, 이벤트 타입을, 선택한 사용유무에 따라서 조회
    List<Point> findAllByUserUUIDAndIsEventTrueAndUsedAndCreateAtBetween(String uuid, Boolean used, LocalDateTime stt, LocalDateTime end);

    //8. 기간없이, 선물 포인트만, 사용 유무에 관계없이 조회
    List<Point> findAllByUserUUIDAndType(String userUUID, PointType type);

    //9. 기간없이, 선물 포인트만, 사용 유무에 따라서 조회
    List<Point> findAllByUserUUIDAndTypeAndUsed(String uuid, PointType type, Boolean used);

    //10. 하루종일, 이벤트타입에 따른 중복체크 조회
    List<Point> findAllByUserUUIDAndTypeAndIsEventTrueAndCreateAtBetween(String uuid, PointType type, LocalDateTime stt, LocalDateTime end);

    //11. 어제의, 출석체크포인트를 검색
    Optional<Point> findByUserUUIDAndTypeAndCreateAtBetween(String uuid, PointType pointType, LocalDateTime start,LocalDateTime end);
}
