package com.example.ajopayback.dto.request;

public class Oauth2Request {
    private String accessToken;

    public Oauth2Request() {
    }

    public Oauth2Request(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
