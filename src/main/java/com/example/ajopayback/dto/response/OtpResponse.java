package com.example.ajopayback.dto.response;

public class OtpResponse {
    private boolean isOtpValid;

    public OtpResponse() {
    }

    public OtpResponse(boolean isOtpValid) {
        this.isOtpValid = isOtpValid;
    }

    public boolean isOtpValid() {
        return isOtpValid;
    }

    public void setOtpValid(boolean otpValid) {
        isOtpValid = otpValid;
    }
}
