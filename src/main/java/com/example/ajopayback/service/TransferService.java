package com.example.ajopayback.service;

import com.example.ajopayback.dto.request.TransferRequest;

public interface TransferService {
    String transferMoney(TransferRequest request);
}
