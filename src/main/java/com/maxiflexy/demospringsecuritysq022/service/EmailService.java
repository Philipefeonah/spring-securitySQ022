package com.maxiflexy.demospringsecuritysq022.service;

import com.maxiflexy.demospringsecuritysq022.dto.EmailDetails;

public interface EmailService {

    void sendEmailAlert(EmailDetails emailDetails);
}
