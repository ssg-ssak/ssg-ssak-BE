package ssgssak.ssgpointuser.club.dto;

import lombok.*;
import ssgssak.ssgpointuser.club.entity.Gender;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MomClubUpdateDto {
    private Gender child1Gender;
    private LocalDate child1Birth;
    private Gender child2Gender;
    private LocalDate child2Birth;
    private Boolean agreement;
}
