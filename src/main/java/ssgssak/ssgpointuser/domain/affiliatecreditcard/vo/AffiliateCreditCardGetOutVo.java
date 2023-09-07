package ssgssak.ssgpointuser.domain.affiliatecreditcard.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ssgssak.ssgpointuser.domain.affiliatecreditcard.entity.AffiliateCreditCard;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateCreditCardGetOutVo {
    private List cardDataList;
}
