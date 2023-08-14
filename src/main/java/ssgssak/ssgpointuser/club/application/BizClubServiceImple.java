package ssgssak.ssgpointuser.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.club.dto.BizClubUpdateDto;

@Service
@RequiredArgsConstructor
public class BizClubServiceImple implements ClubService<BizClubUpdateDto> {
    //todo: repository 생성자 입력(의존성 주입)

    @Override
    public void createClubUser(BizClubUpdateDto clubDto) {

    }

    @Override
    public void updateClubUser(BizClubUpdateDto clubDto) {

    }

    @Override
    public void getClubUserByClubListId(BizClubUpdateDto clubDto) {

    }

    @Override
    public void deleteClubUserByClubListId(BizClubUpdateDto clubDto) {

    }
}
