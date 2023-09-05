package ssgssak.ssgpointuser.domain.onlinepointcard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.onlinepointcard.entity.OnlinePointCard;

import java.util.List;

@Repository
public interface OnlinePointCardRepository extends JpaRepository<OnlinePointCard, Long> {
    List<OnlinePointCard> findAllByUserUUID(String userUUID);
}
