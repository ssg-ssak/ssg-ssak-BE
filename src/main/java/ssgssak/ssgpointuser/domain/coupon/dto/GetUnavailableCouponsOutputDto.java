package ssgssak.ssgpointuser.domain.coupon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.coupon.entity.Coupon;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetUnavailableCouponsOutputDto {
    private List<Coupon> unavailableCoupons;
}