package ssgssak.ssgpointuser.domain.point.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.point.entity.ExchangePoint;

@Repository
public interface ExchangePointRepository extends JpaRepository<ExchangePoint, Long> {
}
