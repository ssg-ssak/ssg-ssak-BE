package ssgssak.ssgpointuser.domain.point.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.point.entity.GiftPoint;
import ssgssak.ssgpointuser.domain.point.entity.GiftStatus;
import ssgssak.ssgpointuser.domain.point.entity.Point;

import java.util.List;

@Repository
public interface GiftPointRepository extends JpaRepository<GiftPoint, Long> {
    /**
     * 1. 유저의 uuid와 success가 false인 point를 조회
     */

    List<GiftPoint> findByReceiverUUIDAndStatusOrderByCreateAtAsc(String uuid, GiftStatus status);

}
