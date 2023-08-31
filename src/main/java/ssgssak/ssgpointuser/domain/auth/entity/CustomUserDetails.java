package ssgssak.ssgpointuser.domain.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ssgssak.ssgpointuser.domain.user.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * User에서 필요한 값만 사용하기 위해서, User를 필드로 사용하는 CustomUserDetails를 사용
 */
public class CustomUserDetails implements UserDetails {

    private User user;
    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * UserDetails의 메소드를 오버라이드
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRoll().toString()));
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    // token에 user를 구분지을 userUUID를 넣어서 사용한다
    @Override
    public String getUsername() {
        return user.getUserUUID();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
