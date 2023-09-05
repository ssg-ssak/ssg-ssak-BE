package ssgssak.ssgpointuser.domain.onlinepointcard.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OnlinePointCardGetOutVo {
    private List onlinePointCardList;
}
