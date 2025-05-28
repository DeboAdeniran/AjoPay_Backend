package com.example.ajopayback.util;

import java.security.SecureRandom;

public class AccountNumberGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateAccountNumber() {
        int randomPart = 10000000 + random.nextInt(90000000);
        return "00" + randomPart;
    }
}
