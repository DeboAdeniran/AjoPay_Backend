package com.example.ajopayback.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class TransferRequest {
    @Schema(
            name = "sender account number"
    )
    private String senderAccount;
    @Schema(
            name = "receiver account number"
    )
    private String receiverAccount;
    @Schema(
            name = "Amount to send"
    )
    private Double amount;
    @Schema(
            name = "description about the transfer"
    )
    private String description;
    @Schema(
            name = "secret pin"
    )
    private String pin;

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
