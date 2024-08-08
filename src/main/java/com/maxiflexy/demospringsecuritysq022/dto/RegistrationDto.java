package com.maxiflexy.demospringsecuritysq022.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDto { // request from user

    private String firstName;

    private String lastName;

    private String email;

    private String password;


}
