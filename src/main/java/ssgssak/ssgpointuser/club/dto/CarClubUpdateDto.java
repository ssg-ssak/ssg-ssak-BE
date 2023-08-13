package ssgssak.ssgpointuser.club.dto;

import lombok.*;
import ssgssak.ssgpointuser.club.entity.Region;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarClubUpdateDto {
    private Region region;
    private String firstNumber;
    private String middleNumber;
    private String lastNumber;
    private Boolean agreeEssential;
    private Boolean agreeSelect;
}
