package com.example.ajopayback.enums;

import lombok.Getter;

@Getter
public enum TransactionStatus {
    SUCCESS,
    FAILED,
    PENDING;

    TransactionStatus() {
    }
}
