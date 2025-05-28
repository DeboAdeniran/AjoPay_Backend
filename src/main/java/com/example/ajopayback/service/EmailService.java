package com.example.ajopayback.service;

import com.example.ajopayback.dto.request.EmailDetails;

public interface EmailService {
    void sendEmailAlert(EmailDetails emailDetails);
}
