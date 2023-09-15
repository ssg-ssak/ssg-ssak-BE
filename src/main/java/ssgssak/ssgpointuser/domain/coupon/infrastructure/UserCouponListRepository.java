package ssgssak.ssgpointuser.domain.coupon.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import ssgssak.ssgpointuser.domain.coupon.entity.UserCouponList;

import java.util.List;

public interface UserCouponListRepository extends JpaRepository<UserCouponList, Long> {
    UserCouponList findByUuidAndCouponId(String uuid, Long couponId);
    List<UserCouponList> findAllByUuidAndIsUsedFalseAndIsExpiredFalse(String uuid);
    List<UserCouponList> findAllByUuidAndIsUsedTrueOrIsExpiredTrue(String uuid);
    List<UserCouponList> findAllByUuidAndIsUsedTrue(String uuid);
    List<UserCouponList> findAllByUuidAndIsExpiredTrue(String uuid);
    List<UserCouponList> findAllByIsExpired(Boolean isExpired);

}
