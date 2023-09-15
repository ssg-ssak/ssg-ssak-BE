package ssgssak.ssgpointuser.domain.club.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MomClubOutputVo {
    private Boolean child1Gender;
    private String child1Birth;
    private Boolean child2Gender;
    private String child2Birth;
    private Boolean agreement;
}
