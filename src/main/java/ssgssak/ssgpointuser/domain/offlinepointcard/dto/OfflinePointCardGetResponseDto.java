package ssgssak.ssgpointuser.domain.offlinepointcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfflinePointCardGetResponseDto {
    private List offlinePointCardList;
}
