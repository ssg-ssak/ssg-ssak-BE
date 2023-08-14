package ssgssak.ssgpointuser.club.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.club.dto.CarClubUpdateDto;

@Service
@RequiredArgsConstructor
public class CarClubServiceImple implements ClubService<CarClubUpdateDto>{
    //todo: repository 생성자 입력(의존성 주입)
    @Override
    public void createClubUser(CarClubUpdateDto clubDto) {

    }

    @Override
    public void updateClubUser(CarClubUpdateDto clubDto) {

    }

    @Override
    public void getClubUserByClubListId(CarClubUpdateDto clubDto) {

    }

    @Override
    public void deleteClubUserByClubListId(CarClubUpdateDto clubDto) {

    }
}
