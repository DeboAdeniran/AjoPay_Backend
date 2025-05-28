package com.example.ajopayback.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ForgotPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fpID;
    private Integer otp;
    private Date expirationTime;
    @OneToOne
    private  User user;

    public ForgotPassword(Integer fpID, Integer otp, Date expirationTime, User user) {
        this.fpID = fpID;
        this.otp = otp;
        this.expirationTime = expirationTime;
        this.user = user;
    }

    public ForgotPassword() {
    }

    public Integer getFpID() {
        return fpID;
    }

    public void setFpID(Integer fpID) {
        this.fpID = fpID;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
