package com.online.exams.mapper;

import com.online.exams.dto.UserDto;
import com.online.exams.entity.User;
import com.online.exams.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserDto> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User toEntity(UserDto dto) {
        return null;
    }

    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .namaLengkap(entity.getNamaLengkap())
                .hp(entity.getHp())
                .role(entity.getRole())
                .active(entity.getActive())
                .build();
    }

    @Override
    public List<User> toEntities(List<UserDto> dtos) {
        return null;
    }

    @Override
    public List<UserDto> toDtos(List<User> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public User fromRequest(UserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .namaLengkap(request.getNamaLengkap())
                .hp(request.getHp())
                .role(request.getRole())
                .active(request.getActive())
                .build();
    }
}
