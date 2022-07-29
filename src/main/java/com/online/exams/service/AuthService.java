package com.online.exams.service;

import com.online.exams.dto.UserDto;
import com.online.exams.request.LoginRequest;

public interface AuthService {

    String login(LoginRequest request);

    void logout(UserDto userDto);
}
