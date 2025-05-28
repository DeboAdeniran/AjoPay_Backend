package com.example.ajopayback.controller;

import com.example.ajopayback.dto.request.FundWalletRequest;
import com.example.ajopayback.dto.request.TransferRequest;
import com.example.ajopayback.service.FundWalletInterface;
import com.example.ajopayback.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private FundWalletInterface fundWalletInterface;


    @PostMapping("/transfer")
    public ResponseEntity<Map<String,String>>  transfer(@RequestBody TransferRequest transferRequest) {
        String response = transferService.transferMoney(transferRequest);
        return ResponseEntity.ok(Collections.singletonMap("message", response));
    }

    @PostMapping("/fundwallet")
    public ResponseEntity<Map<String,String>>  transfer(@RequestBody FundWalletRequest request) {
        String response = fundWalletInterface.fundWallet(request);
        return ResponseEntity.ok(Collections.singletonMap("message", response));
    }
}
