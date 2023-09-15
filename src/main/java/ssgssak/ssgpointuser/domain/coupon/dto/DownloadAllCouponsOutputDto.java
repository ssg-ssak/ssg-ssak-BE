package ssgssak.ssgpointuser.domain.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.coupon.entity.UserCouponList;

import java.util.ArrayList;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DownloadAllCouponsOutputDto {
    ArrayList<UserCouponList> downloadedCoupons;
}
