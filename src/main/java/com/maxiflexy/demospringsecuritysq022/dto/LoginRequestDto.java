package com.maxiflexy.demospringsecuritysq022.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDto {
    private String email;
    private String password;
}
