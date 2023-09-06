package ssgssak.ssgpointuser.domain.affiliatecreditcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateCreditCardGetResponseDto {
    private List affiliateCreditCardList;
}
