package ssgssak.ssgpointuser.domain.drawingevent.vo;

import lombok.*;
import ssgssak.ssgpointuser.domain.drawingevent.entity.Applicant;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class DrawUserOutputVo {
    private List<Applicant> winnerList;
}
