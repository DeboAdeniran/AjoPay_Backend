package com.example.ajopayback.dto.response;

import com.example.ajopayback.util.AccountNumberGenerator;
import lombok.Getter;
import lombok.Setter;


public class ResponseDto {
    private String email;
    private String accountNumber;
    private String message;

    public ResponseDto(String email, String accountNumber, String message) {
        this.email = email;
        this.accountNumber = accountNumber;
        this.message = message;
    }

    public ResponseDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
