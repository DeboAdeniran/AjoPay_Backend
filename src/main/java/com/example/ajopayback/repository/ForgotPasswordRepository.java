package com.example.ajopayback.repository;

import com.example.ajopayback.model.ForgotPassword;
import com.example.ajopayback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, Integer> {
    @Query("select fp from ForgotPassword fp where fp.otp =?1 and fp.user =?2")
    Optional<ForgotPassword> findByOtpAndUser(Integer otp, User user);
}
