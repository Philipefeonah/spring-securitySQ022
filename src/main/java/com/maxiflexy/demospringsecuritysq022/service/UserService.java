package com.maxiflexy.demospringsecuritysq022.service;

import com.maxiflexy.demospringsecuritysq022.dto.AuthResponseDto;
import com.maxiflexy.demospringsecuritysq022.dto.LoginRequestDto;
import com.maxiflexy.demospringsecuritysq022.dto.LoginResponse;
import com.maxiflexy.demospringsecuritysq022.dto.RegistrationDto;

public interface UserService {

    AuthResponseDto registerUser(RegistrationDto registrationDto);

    LoginResponse loginUser(LoginRequestDto loginRequestDto);
}
