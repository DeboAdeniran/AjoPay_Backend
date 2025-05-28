package com.example.ajopayback.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    protected String message;
    protected HttpStatus status;

    public CustomException(String message){
        super(message);
        this.message =message;
    }

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }



}
