package com.example.ajopayback.dto.response;

public class LoginResponseDto {
    private String email;
    private String jwtToken;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String email, String jwtToken) {
        this.email = email;
        this.jwtToken = jwtToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
