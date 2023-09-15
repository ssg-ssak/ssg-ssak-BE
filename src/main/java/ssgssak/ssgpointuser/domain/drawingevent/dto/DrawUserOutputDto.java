package ssgssak.ssgpointuser.domain.drawingevent.dto;

import lombok.*;
import ssgssak.ssgpointuser.domain.drawingevent.entity.Applicant;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DrawUserOutputDto {
    private List<Applicant> winnerList;
}
