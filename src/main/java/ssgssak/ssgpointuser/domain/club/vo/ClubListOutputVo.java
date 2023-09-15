package ssgssak.ssgpointuser.domain.club.vo;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubListOutputVo {
    private List<HashMap<String, Boolean>> myClubList;
}
