package ssgssak.ssgpointuser.domain.offlinepointcard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.offlinepointcard.entity.OfflinePointCard;
import ssgssak.ssgpointuser.domain.onlinepointcard.entity.OnlinePointCard;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfflinePointCardRepository extends JpaRepository<OfflinePointCard, Long> {

    /**
     * 오프라인 포인트카드
     * 1. 카드번호로 조회
     * 2. 유저 UUID로 조회
     */

    // 1. 카드번호로 조회
    Optional<OfflinePointCard> findByCardNumber(String cardNumber);

    // 2. 유저 UUID로 조회
    List<OfflinePointCard> findAllByUserUUID(String userUUID);

}
