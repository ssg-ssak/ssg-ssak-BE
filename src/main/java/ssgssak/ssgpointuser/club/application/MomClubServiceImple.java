package ssgssak.ssgpointuser.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.club.dto.MomClubUpdateDto;

@Service
@RequiredArgsConstructor
public class MomClubServiceImple implements ClubService<MomClubUpdateDto>{
    //todo: repository 생성자 입력(의존성 주입)
    @Override
    public void createClubUser(MomClubUpdateDto clubDto) {

    }

    @Override
    public void updateClubUser(MomClubUpdateDto clubDto) {

    }

    @Override
    public void getClubUserByClubListId(MomClubUpdateDto clubDto) {

    }

    @Override
    public void deleteClubUserByClubListId(MomClubUpdateDto clubDto) {

    }
}
