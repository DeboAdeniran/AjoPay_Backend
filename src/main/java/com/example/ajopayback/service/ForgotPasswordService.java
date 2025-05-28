package com.example.ajopayback.service;

import com.example.ajopayback.dto.request.ChangePassword;
import com.example.ajopayback.dto.request.OtpRequest;
import org.springframework.http.ResponseEntity;

public interface ForgotPasswordService {
    public ResponseEntity<String> verifyEmail(OtpRequest otpRequest);
    public ResponseEntity<String> verifyOtp(Integer otp, String email);
    public ResponseEntity<String> changePasswordHandler(ChangePassword changePassword, String Token);
}
