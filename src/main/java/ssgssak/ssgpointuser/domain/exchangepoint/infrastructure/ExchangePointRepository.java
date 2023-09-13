package ssgssak.ssgpointuser.domain.exchangepoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;

import java.util.Optional;

@Repository
public interface ExchangePointRepository extends JpaRepository<ExchangePoint, Long> {
    /**
     * 전환 포인트
     * 1. 포인트 id로 전환포인트 조회
     */

    Optional<ExchangePoint> findByPointId(Long pointId);
}
