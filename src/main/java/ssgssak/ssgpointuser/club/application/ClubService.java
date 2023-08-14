package ssgssak.ssgpointuser.club.application;

import ssgssak.ssgpointuser.club.dto.BizClubUpdateDto;
import ssgssak.ssgpointuser.club.dto.CarClubUpdateDto;
import ssgssak.ssgpointuser.club.dto.MomClubUpdateDto;

public interface ClubService<Club> {
    void createClubUser(Club clubDto);
    void updateClubUser(Club clubDto);
    void getClubUserByClubListId(Club clubDto);
    void deleteClubUserByClubListId(Club clubDto);
}
