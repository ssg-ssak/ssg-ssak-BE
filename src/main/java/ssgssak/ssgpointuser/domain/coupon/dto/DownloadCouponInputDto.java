package ssgssak.ssgpointuser.domain.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadCouponInputDto {
    private Long couponId; //todo: 안될경우 String으로 변경
}
