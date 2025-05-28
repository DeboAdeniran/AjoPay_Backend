package com.example.ajopayback.dto.request;

import com.example.ajopayback.model.User;

import java.time.LocalDateTime;

public class SavingRequest {
    private User user;
    private String externalAccountNumber;
    private double amount;
    private LocalDateTime startDate;
    private int durationInMonths;
    private String savingTime;

    public SavingRequest() {
    }

    public SavingRequest(User user, String externalAccountNumber, double amount, LocalDateTime startDate, int durationInMonths, String savingTime) {
        this.user = user;
        this.externalAccountNumber = externalAccountNumber;
        this.amount = amount;
        this.startDate = startDate;
        this.durationInMonths = durationInMonths;
        this.savingTime = savingTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExternalAccountNumber() {
        return externalAccountNumber;
    }

    public void setExternalAccountNumber(String externalAccountNumber) {
        this.externalAccountNumber = externalAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public String getSavingTime() {
        return savingTime;
    }

    public void setSavingTime(String savingTime) {
        this.savingTime = savingTime;
    }
}
