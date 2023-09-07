package ssgssak.ssgpointuser.domain.affiliatepointcard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCard;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCardType;

import java.util.Optional;

@Repository
public interface AffiliatePointCardRepository extends JpaRepository<AffiliatePointCard, Long> {

    Optional<AffiliatePointCard> findByUserUUIDAndType(String userUUID, AffiliatePointCardType type);

}
