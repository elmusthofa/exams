package com.online.exams.util;

import com.online.exams.config.AppAuthenticationConfig;
import com.online.exams.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static AppAuthenticationConfig getAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AppAuthenticationConfig) {
            return (AppAuthenticationConfig) authentication;
        }
        return null;
    }

    public static UserDto getAuthUser() {
        AppAuthenticationConfig authentication = getAuth();
        if (authentication != null) {
            return authentication.getDetails();
        } else throw Checks.newE("not authenticated");
    }
}
