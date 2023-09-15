package ssgssak.ssgpointuser.domain.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownloadCouponOutputVo {
    private Long id;
    private Long couponId;
    private LocalDate downloadDate;
    private Boolean isUsed;
    private Boolean isExpired;
}