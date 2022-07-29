package com.online.exams.filter;

import com.online.exams.config.AppAuthenticationConfig;
import com.online.exams.dto.UserDto;
import com.online.exams.entity.AuthSession;
import com.online.exams.exception.Constant;
import com.online.exams.mapper.UserMapper;
import com.online.exams.repository.AuthSessionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author muhamad.fariz
 * email : farizcb@gmail.com
 * on 26/03/2022
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final AuthSessionRepository authSessionRepository;
    private final UserMapper userMapper;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(Constant.HEADER_AUTHORIZATION);
        if (StringUtils.isBlank(authHeader)) {
            chain.doFilter(request, response);
            return;
        }
        String token = authHeader.substring(7);
        AuthSession authSession = authSessionRepository.findByToken(token).orElse(null);
        SecurityContextHolder.getContext().setAuthentication(new AppAuthenticationConfig(new UserDto()));
        if (authSession != null) {
            SecurityContextHolder.getContext().setAuthentication(new AppAuthenticationConfig(userMapper.toDto(authSession.getUser())));
        } else {
            response.sendError(401, "Token not found !");
        }
        chain.doFilter(request, response);
    }

}
