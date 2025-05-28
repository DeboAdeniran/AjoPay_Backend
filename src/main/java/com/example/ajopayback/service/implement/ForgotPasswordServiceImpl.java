package com.example.ajopayback.service.implement;

import com.example.ajopayback.dto.request.ChangePassword;
import com.example.ajopayback.dto.request.OtpRequest;
import com.example.ajopayback.repository.ForgotPasswordRepository;
import com.example.ajopayback.repository.UserRepository;
import com.example.ajopayback.service.EmailService;
import com.example.ajopayback.service.ForgotPasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final ForgotPasswordRepository forgotPasswordRepository;
    private final PasswordEncoder passwordEncoder;
    private final String secretKey = "/wxcuLWHieW3/1/EtnE1XBp5dD6Nj4KzBn5FIKaF2bU=";

    public ForgotPasswordServiceImpl(UserRepository userRepository, EmailService emailService, ForgotPasswordRepository forgotPasswordRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.forgotPasswordRepository = forgotPasswordRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<String> verifyEmail(OtpRequest otpRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> verifyOtp(Integer otp, String email) {
        return null;
    }

    @Override
    public ResponseEntity<String> changePasswordHandler(ChangePassword changePassword, String Token) {
        return null;
    }
}
