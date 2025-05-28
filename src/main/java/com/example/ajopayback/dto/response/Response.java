package com.example.ajopayback.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;


public class Response {
    private int statusCode;
    private String responseMessage;
    private UserInfo userInfo;
    private OtpResponse otpResponse;

    public Response(OtpResponse otpResponse, String responseMessage, int statusCode, UserInfo userInfo) {
        this.otpResponse = otpResponse;
        this.responseMessage = responseMessage;
        this.statusCode = statusCode;
        this.userInfo = userInfo;
    }

    public Response() {
    }

    public OtpResponse getOtpResponse() {
        return otpResponse;
    }

    public void setOtpResponse(OtpResponse otpResponse) {
        this.otpResponse = otpResponse;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
