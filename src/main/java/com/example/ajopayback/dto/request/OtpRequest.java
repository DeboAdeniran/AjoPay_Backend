package com.example.ajopayback.dto.request;

public class OtpRequest {
    private String email;

    public OtpRequest(String email) {
        this.email = email;
    }

    public OtpRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
