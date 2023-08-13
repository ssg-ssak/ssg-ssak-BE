package ssgssak.ssgpointuser.club.application;

import ssgssak.ssgpointuser.club.dto.BizClubUpdateDto;
import ssgssak.ssgpointuser.club.dto.CarClubUpdateDto;
import ssgssak.ssgpointuser.club.dto.MomClubUpdateDto;

public interface ClubServiceInterface {
    //todo: 클럽별 서비스 메서드를 하나의 파일에 작성했습니다. 추후에 분리가 필요한지 판단 필요.
    void getClubUserByClubListId(String ClubListId);
    /*
    맘키즈 클럽 서비스 관련 메서드입니다.
     */
    void createMomClubUser(MomClubUpdateDto momClubSignUpDto);
    void updateMomClubUser(MomClubUpdateDto momClubUpdateDto);
    void deleteMomClubUser(String ClubListId);
    /*
    비즈니스 클럽 서비스 관련 메서드입니다.
     */
    void createBizClubUser(BizClubUpdateDto bizClubSignUpDto);
    void updateBizClubUser(BizClubUpdateDto bizClubUpdateDto);
    void deleteBizClubUser(String ClubListId);
    /*
    차량 서비스 관련 메서드입니다.
     */
    void createCarClubUser(CarClubUpdateDto carClubSignUpDto);
    void updateCarClubUser(CarClubUpdateDto carClubUpdateDto);
    void deleteCarClubUser(String ClubListId);
}
