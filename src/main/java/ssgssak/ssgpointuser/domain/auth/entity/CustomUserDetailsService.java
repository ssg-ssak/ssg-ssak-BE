package ssgssak.ssgpointuser.domain.auth.entity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 1. uuid로 유저 검색
     * 2. loginId로 유저 검색
     * -> 로그인 or 유저식별을, 단 하나의 값(ex.이메일)을 사용한다면, 1번과 2번으로 나누어 진행할 필요가 없다
     * -> 하지만 우리는 uuid로 유저를 식별하고, 로그인은 loginId를 사용하기 떄문에 두 개로 나누어 주었다
     */

    // 1. 토큰에서 추출한 uuid로 유저를 가져와서, UserDeatilsService를 생성한다
    public CustomUserDetails loadUserByUUID(String uuid) throws UsernameNotFoundException {
        User uuidUser = userRepository.findUserByUserUUID(uuid).orElseThrow(()-> new NoSuchElementException());
        return new CustomUserDetails(uuidUser);
    }

    // 2. 로그인시 전달받은 login ID로 유저를 가져와서, userDetailsService를 생성한다
    @Override
    public CustomUserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User loginUser = userRepository.findByUserId(loginId).orElseThrow(() -> new NoSuchElementException());
        return new CustomUserDetails(loginUser);
    }
}
