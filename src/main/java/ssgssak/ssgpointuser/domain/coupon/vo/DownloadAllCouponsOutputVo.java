package ssgssak.ssgpointuser.domain.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.coupon.entity.UserCouponList;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DownloadAllCouponsOutputVo {
    ArrayList<UserCouponList> downloadedCoupons;
}
