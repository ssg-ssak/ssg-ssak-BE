package ssgssak.ssgpointuser.domain.storepoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;

import java.util.Optional;

@Repository
public interface StorePointRepository extends JpaRepository<StorePoint, Long> {
    /**
     * 1. 포인트id로 조회
     */

    // 1. 포인트 id로 조회
    Optional<StorePoint> findByPointId(Long pointId);
}
