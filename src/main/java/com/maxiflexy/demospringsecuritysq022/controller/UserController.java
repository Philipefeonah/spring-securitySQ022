package com.maxiflexy.demospringsecuritysq022.controller;

import com.maxiflexy.demospringsecuritysq022.dto.AuthResponseDto;
import com.maxiflexy.demospringsecuritysq022.dto.LoginRequestDto;
import com.maxiflexy.demospringsecuritysq022.dto.LoginResponse;
import com.maxiflexy.demospringsecuritysq022.dto.RegistrationDto;
import com.maxiflexy.demospringsecuritysq022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<AuthResponseDto> registerUser(@RequestBody RegistrationDto registrationDto){
        return ResponseEntity.ok(userService.registerUser(registrationDto));
    }

    @PostMapping("/login-user")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(userService.loginUser(loginRequestDto));
    }
}
