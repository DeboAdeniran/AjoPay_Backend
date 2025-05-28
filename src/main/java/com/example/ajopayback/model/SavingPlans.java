package com.example.ajopayback.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class SavingPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String externalAccountNumber;

    private Double amount;
    private LocalDateTime startDate;
    private int durationInMonths;
    private String savingTime;

    private boolean active = true;

    public boolean isExpired(){return startDate.plusMonths(durationInMonths).isBefore(LocalDateTime.now());}

    public SavingPlans() {
    }

    public SavingPlans(long id, User user, String externalAccountNumber, Double amount, LocalDateTime startDate, int durationInMonths, String savingTime, boolean active) {
        this.id = id;
        this.user = user;
        this.externalAccountNumber = externalAccountNumber;
        this.amount = amount;
        this.startDate = startDate;
        this.durationInMonths = durationInMonths;
        this.savingTime = savingTime;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "SavingPlans{" +
                "id=" + id +
                ", user=" + user +
                ", externalAccountNumber='" + externalAccountNumber + '\'' +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", durationInMonths=" + durationInMonths +
                ", savingTime='" + savingTime + '\'' +
                ", active=" + active +
                '}';
    }
}
