package com.parkinglot.model;

import com.parkinglot.enums.PaymentMode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Payment {
    private String referenceNumber;
    private PaymentMode paymentMode;
    private BigDecimal amount;
    private Date paymentDateTime;

    public Payment(String referenceNumber, PaymentMode paymentMode, BigDecimal amount, Date paymentDateTime) {
        this.referenceNumber = referenceNumber;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
    }
}
