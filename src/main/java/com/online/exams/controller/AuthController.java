package com.online.exams.controller;

import com.online.exams.config.AppAuthenticationConfig;
import com.online.exams.dto.UserDto;
import com.online.exams.request.LoginRequest;
import com.online.exams.service.AuthService;
import com.online.exams.util.Checks;
import com.online.exams.util.JsonResponse;
import com.online.exams.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "auth", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Auth Api", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Auth"})
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    @ApiOperation(value = "login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(JsonResponse.ok(authService.login(request)));
    }

    @PostMapping("logout")
    @ApiOperation(value = "logout")
    public ResponseEntity<?> logout() {
        AppAuthenticationConfig auth = SecurityUtil.getAuth();
        Checks.isTrue(auth != null, "Silahkan login terlebih dahulu");
        UserDto userDto = auth.getDetails();
        authService.logout(userDto);
        return ResponseEntity.ok(JsonResponse.ok("Berhasil logout"));
    }
}
