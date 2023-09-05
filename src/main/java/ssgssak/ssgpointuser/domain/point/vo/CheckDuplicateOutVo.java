package ssgssak.ssgpointuser.domain.point.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckDuplicateOutVo { //outVo에는 Getter 꼭 사용해야한다!
    private Boolean duplicate;
}
