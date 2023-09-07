package ssgssak.ssgpointuser.domain.affiliatecreditcard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCard;

import java.util.List;

@Repository
public interface AffiliateCreditCardRepository extends JpaRepository<AffiliateCreditCard, Long> {

    List<AffiliateCreditCard> findAllByUserUUID(String userUUID);


}
