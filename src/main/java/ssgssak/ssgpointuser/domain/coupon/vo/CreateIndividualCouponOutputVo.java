package ssgssak.ssgpointuser.domain.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateIndividualCouponOutputVo {
    private Long id;
    private Long couponId;
    private String couponNumber;
    private String barcodeUrl;
    private Boolean isRegistered;
}