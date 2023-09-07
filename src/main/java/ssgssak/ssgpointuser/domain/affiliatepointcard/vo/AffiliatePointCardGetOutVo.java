package ssgssak.ssgpointuser.domain.affiliatepointcard.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.affiliatepointcard.entity.AffiliatePointCard;

import java.util.HashMap;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AffiliatePointCardGetOutVo {
    private HashMap card;
}
