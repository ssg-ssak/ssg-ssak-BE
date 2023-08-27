package ssgssak.ssgpointuser.domain.exchangepoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.exchangepoint.entity.ExchangePoint;

@Repository
public interface ExchangePointRepository extends JpaRepository<ExchangePoint, Long> {
}
