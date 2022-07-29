package com.online.exams.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.online.exams.dto.UserDto;
import com.online.exams.entity.AuthSession;
import com.online.exams.entity.User;
import com.online.exams.repository.AuthSessionRepository;
import com.online.exams.repository.UserRepository;
import com.online.exams.request.LoginRequest;
import com.online.exams.service.AuthService;
import com.online.exams.util.Checks;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthSessionRepository authSessionRepository;

    @Value("${app.jwt-secret-key:secret-Key}")
    private String jwtSecretKey;

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByUsernameOrEmail(request.getUsername().toLowerCase(), request.getUsername().toLowerCase());
        Checks.isTrue(user != null, "Username atau password salah");
        String token = JWT.create()
                .withClaim("namaLengkap", user.getNamaLengkap())
                .withClaim("role", user.getRole().name())
                .withClaim("userId", user.getId())
                .withSubject(user.getId())
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC512(jwtSecretKey));
        authSessionRepository.deleteAll(authSessionRepository.findByUserId(user.getId()));
        AuthSession authSession = new AuthSession();
        authSession.setToken(token);
        authSession.setUser(user);
        authSessionRepository.save(authSession);
        return token;
    }

    @Override
    public void logout(UserDto userDto) {
        authSessionRepository.deleteAll(authSessionRepository.findByUserId(userDto.getId()));
    }
}
