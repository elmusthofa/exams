package com.online.exams.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.exams.util.JsonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
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
public class LocalIpFilter extends OncePerRequestFilter {

    private final ObjectMapper mapper;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain chain) throws ServletException, IOException {

        if (request.getHeader("X-FORWARDED-FOR") != null) {
            JsonResponse<?> json = JsonResponse.ok(401, "Unauthorized IP", null);
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().print(mapper.writeValueAsString(json));
            return;
        }

        chain.doFilter(request, response);
    }

}
