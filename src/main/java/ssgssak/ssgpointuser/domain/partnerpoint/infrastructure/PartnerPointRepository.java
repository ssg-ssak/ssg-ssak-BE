package ssgssak.ssgpointuser.domain.partnerpoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import ssgssak.ssgpointuser.domain.partnerpoint.entity.PartnerPoint;

public interface PartnerPointRepository extends JpaRepository<PartnerPoint, Long> {
}
