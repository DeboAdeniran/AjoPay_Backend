package com.example.ajopayback.model;

import com.example.ajopayback.enums.FundWalletStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FundWallet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long FundWalletid;
    private String senderAccount;
    private String senderBank;
    private String recepientAccount;
    private Double amount;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private FundWalletStatus status;

    public FundWallet() {
    }

    public FundWallet(long fundWalletid, String senderAccount, String senderBank, String recepientAccount, Double amount, LocalDateTime timestamp, FundWalletStatus status) {
        FundWalletid = fundWalletid;
        this.senderAccount = senderAccount;
        this.senderBank = senderBank;
        this.recepientAccount = recepientAccount;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    public long getFundWalletid() {
        return FundWalletid;
    }

    public void setFundWalletid(long fundWalletid) {
        FundWalletid = fundWalletid;
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

    public String getRecepientAccount() {
        return recepientAccount;
    }

    public void setRecepientAccount(String recepientAccount) {
        this.recepientAccount = recepientAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public FundWalletStatus getStatus() {
        return status;
    }

    public void setStatus(FundWalletStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FundWallet{" +
                "FundWalletid=" + FundWalletid +
                ", senderAccount='" + senderAccount + '\'' +
                ", senderBank='" + senderBank + '\'' +
                ", recepientAccount='" + recepientAccount + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}
