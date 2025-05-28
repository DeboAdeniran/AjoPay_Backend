package com.example.ajopayback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@Entity
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String otp;
    private String email;
    @CreationTimestamp
    private LocalDateTime createdAT;
    private LocalDateTime expireAT;

    public Otp() {
    }

    public Otp(Long id, String otp, String email, LocalDateTime createdAT, LocalDateTime expireAT) {
        Id = id;
        this.otp = otp;
        this.email = email;
        this.createdAT = createdAT;
        this.expireAT = expireAT;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public LocalDateTime getExpireAT() {
        return expireAT;
    }

    public void setExpireAT(LocalDateTime expireAT) {
        this.expireAT = expireAT;
    }
}
