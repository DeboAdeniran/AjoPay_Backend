package com.example.ajopayback.enums;

import lombok.Getter;

@Getter
public enum FundWalletStatus {
    SUCCESS,
    FAILED,
    PENDING;

    FundWalletStatus() {
    }
}
