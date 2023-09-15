package ssgssak.ssgpointuser.domain.club.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.club.dto.MomClubDto;
import ssgssak.ssgpointuser.domain.club.entity.ClubList;
import ssgssak.ssgpointuser.domain.club.entity.MomClub;
import ssgssak.ssgpointuser.domain.club.infrastructure.ClubListRepository;
import ssgssak.ssgpointuser.domain.club.infrastructure.MomClubRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MomClubServiceImpl implements ClubService<MomClubDto>{
    private final MomClubRepository momClubRepository;
    private final ClubListRepository clubListRepository;
    private final ModelMapper modelMapper;

    // VO에서 받아온 String을 LocalDate로 변환.
    private static final DateTimeFormatter stringToDate = DateTimeFormatter.ofPattern("yyyyMMdd");

    // 유저 클럽 정보 생성
    @Override
    public void createClubUser(MomClubDto createDto, String uuid) {
        // 가입되어있는지 확인(중복 가입 방지)
        ClubList clubList = clubListRepository.findByUuid(uuid);
        if(clubList.getMomClub() != null) {
            throw new IllegalArgumentException("이미 클럽에 가입되어 있습니다.");
        }

        MomClub momClub = null;
        /*
        Child2 정보의 유무에 따라 분기
         */
        if(createDto.getChild2Gender() == null && createDto.getChild2Birth() == null){
            momClub = MomClub.builder()
                    .child1Gender(createDto.getChild1Gender())
                    .child1Birth(LocalDate.parse(createDto.getChild1Birth(), stringToDate))
                    .agreement(createDto.getAgreement())
                    .build();
        }
        else if (createDto.getChild2Gender() != null && createDto.getChild2Birth() != null){
            momClub = MomClub.builder()
                    .child1Gender(createDto.getChild1Gender())
                    .child1Birth(LocalDate.parse(createDto.getChild1Birth(), stringToDate))
                    .child2Gender(createDto.getChild2Gender())
                    .child2Birth(LocalDate.parse(createDto.getChild2Birth(), stringToDate))
                    .agreement(createDto.getAgreement())
                    .build();
        }
        else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        momClubRepository.save(momClub);
        /*
        clubList의 MomClub필드에 생성한 momClub 추가
         */
        clubList.updateMomClubInfo(momClub);
        clubListRepository.save(clubList);
    }
    // 유저 클럽 정보 가져오기
    @Override
    public MomClubDto getClubUser(String uuid) {
        /*
        ClubList 데이터들 중 uuid를 가지고 MomClub이 null이 아닌 데이터를 찾는다.
         */
        ClubList clubList = clubListRepository.findByUuid(uuid);
        MomClub momClub = momClubRepository.findById(
                        (clubList.getMomClub()).getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));
        return modelMapper.map(momClub, MomClubDto.class);
    }
    // 유저 클럽 정보 수정/삭제
    @Override
    public void updateClubUser(MomClubDto updateDto, String uuid) {
        /*
        ClubList 데이터들 중 uuid를 가지고 MomClub이 null이 아닌 데이터를 찾는다.
         */
        ClubList clubList = clubListRepository.findByUuid(uuid);

        MomClub momClub = momClubRepository.findById(clubList.getMomClub().getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 클럽이 존재하지 않습니다."));

        if(!updateDto.getAgreement()){
            clubList.updateMomClubInfo(null);
            clubListRepository.save(clubList);
            momClubRepository.delete(momClub);
        }
        else {
            momClub.updateFirstChildInfo(
                    updateDto.getChild1Gender(), LocalDate.parse(updateDto.getChild1Birth(), stringToDate)
            );
            if(updateDto.getChild2Gender() != null && updateDto.getChild2Birth() != null){
                momClub.updateSecondChildInfo(
                        updateDto.getChild2Gender(), LocalDate.parse(updateDto.getChild2Birth(), stringToDate)
                );
            }
            momClubRepository.save(momClub);
        }
    }
}