package ssgssak.ssgpointuser.domain.point.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckDuplicateOutVo { //todo: outVo에 getter 사용안해봤는데, 잘 된다면 다른곳도 바꾸기 -> Getter 꼭 사용해야한다!
    private Boolean duplicate;
}
