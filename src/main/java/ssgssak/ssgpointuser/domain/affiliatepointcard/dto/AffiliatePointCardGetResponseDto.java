package ssgssak.ssgpointuser.domain.affiliatepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AffiliatePointCardGetResponseDto {
    private List affiliatePointCardList;
}
