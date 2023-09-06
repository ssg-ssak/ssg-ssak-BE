package ssgssak.ssgpointuser.domain.offlinepointcard.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfflinePointCardGetOutVo {
    private List offlinePointCardList;
}
