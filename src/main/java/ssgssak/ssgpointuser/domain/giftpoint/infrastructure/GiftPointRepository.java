package ssgssak.ssgpointuser.domain.giftpoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftPoint;
import ssgssak.ssgpointuser.domain.giftpoint.entity.GiftStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GiftPointRepository extends JpaRepository<GiftPoint, Long> {
    /**
     * 1. receiverUUID, receivePointId 로, giftPoint 조회
     * 2. receiverUUID, success로, giftPoint 조회
     * 3. giverUUID, givePointId 로, giftPoint 조회
     * 4.
     */

    // 1. receiverUUID, receivePointId 로, 선물 조회
    Optional<GiftPoint> findByReceiverUUIDAndReceivePointId(String receiverUUID, Long receivePointId);

    // 2. receiverUUID, success로, giftPoint 조회
    List<GiftPoint> findByReceiverUUIDAndStatusOrderByCreateAtAsc(String uuid, GiftStatus status);

    // 3. giverUUID, createAt으로, 선물 조회
    Optional<GiftPoint> findByGiverUUIDAndGivePointId(String uuid, Long givePointId);


}
