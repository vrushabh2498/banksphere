package com.banksphere.transactionservice.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TransactionReferenceUtil {

    private TransactionReferenceUtil() {
    }

    public static String generateTransactionReference() {

        String timestamp = LocalDateTime.now()
                .format(
                        DateTimeFormatter.ofPattern(
                                "yyyyMMddHHmmss"
                        )
                );

        String uniqueId = UUID.randomUUID()
                .toString()
                .substring(0, 6)
                .toUpperCase();

        return "TXN" + timestamp + uniqueId;
    }
}