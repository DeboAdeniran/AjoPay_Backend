package com.example.ajopayback.dto.request;

public class FundWalletRequest {

    private String senderAccount;
    private String senderBank;
    private String recipientAccount;
    private double amount;
    private String otp;
    private String pin;

    public FundWalletRequest() {
    }

    public FundWalletRequest(String senderAccount, String senderBank, String recipientAccount, double amount, String otp, String pin) {
        this.senderAccount = senderAccount;
        this.senderBank = senderBank;
        this.recipientAccount = recipientAccount;
        this.amount = amount;
        this.otp = otp;
        this.pin = pin;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderBank() {
        return senderBank;
    }

    public void setSenderBank(String senderBank) {
        this.senderBank = senderBank;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
