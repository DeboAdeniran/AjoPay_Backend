package com.example.ajopayback.dto.response;

public class UserInfo {
    private String firstName;
    private String surname;

    public UserInfo(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public UserInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //    public static final String  USER_EXIST_MESSAGE = " This user already exist";
}
