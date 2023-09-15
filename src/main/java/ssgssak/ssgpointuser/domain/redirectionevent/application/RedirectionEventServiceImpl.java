package ssgssak.ssgpointuser.domain.redirectionevent.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssgssak.ssgpointuser.domain.redirectionevent.dto.CreateRedirectionEventInputDto;
import ssgssak.ssgpointuser.domain.redirectionevent.dto.GetRedirectionEventDto;
import ssgssak.ssgpointuser.domain.redirectionevent.dto.UpdateRedirectionEventDto;
import ssgssak.ssgpointuser.domain.redirectionevent.entity.RedirectionEvent;
import ssgssak.ssgpointuser.domain.redirectionevent.infrastructure.RedirectionEventRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class RedirectionEventServiceImpl {
    private final RedirectionEventRepository redirectionEventRepository;
    private final ModelMapper modelMapper;
    /*
    1. 새로운 이벤트 생성
    2. 이벤트 정보 변경(이벤트 이름, 이미지 변경)
    3. 이벤트 정보 조회
     */

    // 1. 새로운 이벤트 생성
    public void createRedirectionEvent(CreateRedirectionEventInputDto createRedirectionEventInputDto) {
        RedirectionEvent redirectionEvent = modelMapper.map(createRedirectionEventInputDto, RedirectionEvent.class);
        redirectionEventRepository.save(redirectionEvent);
    }

    // 2. 이벤트 정보 변경
    public void updateRedirectionEvent(UpdateRedirectionEventDto updateRedirectionEventDto, Long eventListId) {
        RedirectionEvent redirectionEvent = redirectionEventRepository.findByEventListId(eventListId);
        redirectionEvent.updateRedirectionEvent(
                updateRedirectionEventDto.getTitle(),
                updateRedirectionEventDto.getTitleImageUrl(),
                updateRedirectionEventDto.getRedirectionUrl(),
                updateRedirectionEventDto.getContentsImageUrl()
        );
    }

    // 3. 이벤트 정보 조회
    @Transactional(readOnly = true)
    public GetRedirectionEventDto getRedirectionEvent(Long eventListId) {
        RedirectionEvent redirectionEvent = redirectionEventRepository.findByEventListId(eventListId);
        return modelMapper.map(redirectionEvent, GetRedirectionEventDto.class);
    }
}
