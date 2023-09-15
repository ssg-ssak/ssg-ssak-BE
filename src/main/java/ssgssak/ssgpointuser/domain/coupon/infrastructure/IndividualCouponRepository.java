package ssgssak.ssgpointuser.domain.coupon.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.coupon.entity.IndividualCoupon;

import java.util.Optional;

@Repository
public interface IndividualCouponRepository extends JpaRepository<IndividualCoupon, Long> {
    Optional<IndividualCoupon> findFirstByCouponIdAndIsRegisteredFalse(Long couponId);
    Optional<IndividualCoupon> findFirstByCouponNumberAndIsRegisteredFalse(String couponNumber);
    Optional<IndividualCoupon> findByCouponIdAndUuidAndIsRegisteredTrue(Long couponId, String uuid);
}
