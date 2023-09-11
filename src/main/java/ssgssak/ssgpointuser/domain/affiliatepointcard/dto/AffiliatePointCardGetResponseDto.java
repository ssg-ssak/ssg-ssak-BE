package ssgssak.ssgpointuser.domain.affiliatepointcard.dto;

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
public class AffiliatePointCardGetResponseDto {
    private HashMap card;
}