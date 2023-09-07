package ssgssak.ssgpointuser.domain.affiliatepointcard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCard;

import java.util.List;

@Repository
public interface AffiliatePointCardRepository extends JpaRepository<AffiliatePointCard, Long> {

    List<AffiliatePointCard> findAllByUserUUID(String userUUID);

}
