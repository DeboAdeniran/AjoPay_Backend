package com.example.ajopayback.repository;

import com.example.ajopayback.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByEmail(String email);
}
