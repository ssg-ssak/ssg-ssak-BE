package ssgssak.ssgpointuser.domain.giftpoint.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftPointWaitListOutVo {
    private List waitList;
}
