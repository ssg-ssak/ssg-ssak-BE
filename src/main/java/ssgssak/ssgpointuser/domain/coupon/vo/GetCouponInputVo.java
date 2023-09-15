package ssgssak.ssgpointuser.domain.coupon.vo;

import lombok.Getter;

@Getter
public class GetCouponInputVo {
    private String couponId;

    public GetCouponInputVo(String couponId) {
        this.couponId = couponId;
    }
}
