package ssgssak.ssgpointuser.domain.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualCouponOutputDto {
    private Long id;
    private Long couponId;
    private String couponNumber;
    private String barcodeUrl;
    private Boolean isRegistered;
}