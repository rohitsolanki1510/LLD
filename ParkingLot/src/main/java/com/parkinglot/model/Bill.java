package com.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Bill {
    private Ticket ticket;
    private BigDecimal amount;
    private Gate gate;
    private Attendant attendant;
    private LocalDateTime exitDateTime;
    private List<Payment> paymentList;


}
