package ssgssak.ssgpointuser.domain.franchise.application;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.franchise.dto.FranchiseGetResponseDto;
import ssgssak.ssgpointuser.domain.franchise.entity.Franchise;
import ssgssak.ssgpointuser.domain.franchise.infrastructure.FranchiseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FranchiseServiceImpl implements FranchiseService{
    private final FranchiseRepository franchiseRepository;
    private final ModelMapper modelMapper;

    /**
     * 가맹점
     * 1. 모든 가맹점 조회
     */

    // 1. 모든 가맹점 조회
    public FranchiseGetResponseDto getFranchise() {
        List<Franchise> franchiseList = franchiseRepository.findAll();
        return FranchiseGetResponseDto.builder().franchiseList(franchiseList).build();
    }

}
