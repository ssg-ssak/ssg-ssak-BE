package ssgssak.ssgpointuser.domain.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import ssgssak.ssgpointuser.domain.user.infrastructure.UserRepository;
import ssgssak.ssgpointuser.global.config.jwt.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class AuthSecurityService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;



}
