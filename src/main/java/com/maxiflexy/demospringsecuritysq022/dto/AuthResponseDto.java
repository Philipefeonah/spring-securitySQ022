package com.maxiflexy.demospringsecuritysq022.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDto { // returns response

    private String responseCode;

    private String responseMessage;

    private RegistrationInfo registrationInfo;
}
