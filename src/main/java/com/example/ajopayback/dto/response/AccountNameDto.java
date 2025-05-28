package com.example.ajopayback.dto.response;

public class AccountNameDto {
    private String firstName;
    private String surName;

    public AccountNameDto(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public AccountNameDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
