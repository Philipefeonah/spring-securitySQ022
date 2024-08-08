package com.maxiflexy.demospringsecuritysq022.service.impl;

import com.maxiflexy.demospringsecuritysq022.config.JwtService;
import com.maxiflexy.demospringsecuritysq022.dto.*;
import com.maxiflexy.demospringsecuritysq022.entity.UserEntity;
import com.maxiflexy.demospringsecuritysq022.enums.Role;
import com.maxiflexy.demospringsecuritysq022.repository.UserRepository;
import com.maxiflexy.demospringsecuritysq022.service.EmailService;
import com.maxiflexy.demospringsecuritysq022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Override
    public AuthResponseDto registerUser(RegistrationDto registrationDto) {
        UserEntity user = UserEntity.builder()
                                .firstName(registrationDto.getFirstName())
                                .lastName(registrationDto.getLastName())
                                .email(registrationDto.getEmail())
                                .password(passwordEncoder.encode(registrationDto.getPassword()))
                                .role(Role.USER)
                                .build();

        userRepository.save(user);

        // send email alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(user.getEmail())
                .subject("Account Creation")
                .messageBody("Congratulations! Your Account has been successfully created")
                .build();

        emailService.sendEmailAlert(emailDetails);


        return AuthResponseDto.builder()
                .responseCode("001")
                .responseMessage("Account created successfully")
                .registrationInfo(RegistrationInfo.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build())
                .build();
    }

    @Override
    public LoginResponse loginUser(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(),
                loginRequestDto.getPassword()
        ));

        UserEntity user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return LoginResponse.builder()
                .responseCode("002")
                .responseMessage("Login Successfully")
                .loginInfo(LoginInfo.builder()
                        .email(user.getEmail())
                        .token(jwtToken)
                        .build())
                .build();

    }
}
