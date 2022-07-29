package com.online.exams.config;

import com.online.exams.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppAuthenticationConfig implements Authentication {

    private final UserDto userDto;
    private boolean authenticated;

    public AppAuthenticationConfig(@NotNull UserDto userDto) {
        this.userDto = userDto;
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userDto.getRole().name()));
        return authorities;
    }

    @Override
    public String getCredentials() {
        return userDto.getUsername();
    }

    @Override
    public UserDto getDetails() {
        return userDto;
    }

    @Override
    public String getPrincipal() {
        return userDto.getId();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.authenticated = b;
    }

    @Override
    public String getName() {
        return userDto.getNamaLengkap();
    }
}
