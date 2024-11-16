package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

import java.math.BigDecimal;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public BigDecimal calculateFees(Ticket ticket) {
        return null;
    }
}
