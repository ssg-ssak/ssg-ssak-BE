package ssgssak.ssgpointuser.domain.auth.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.user.entity.User;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 로그인시 전달받은 login ID로 유저를 가져온다
     * 이후, 가져온 유저를 이용해 userDetails를 생성한다
     */
    @Override
    public CustomUserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(loginId).orElseThrow(()-> new NoSuchElementException());
        return new CustomUserDetails(user);
    }
}
