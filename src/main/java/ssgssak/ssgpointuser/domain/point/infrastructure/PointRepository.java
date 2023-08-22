package ssgssak.ssgpointuser.domain.point.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.point.entity.Point;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    /**
     * 포인트
     * 1. 유저의 가장 최신 Point 조회
     */

    Optional<Point> findFirstByUserUUIDOrderByCreateAtDesc(String uuid);

}
