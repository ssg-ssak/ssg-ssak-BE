package ssgssak.ssgpointuser.domain.club.application;

import ssgssak.ssgpointuser.domain.club.dto.ClubListDto;

public interface ClubListService {
    void createClubList(String uuid);
    ClubListDto getMyClubList(String uuid);

    void deleteClubList(String uuid);
}
