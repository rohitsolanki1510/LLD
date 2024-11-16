package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculateFees(Ticket ticket);
}
