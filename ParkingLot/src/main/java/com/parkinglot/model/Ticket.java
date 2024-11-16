package com.parkinglot.model;

import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Getter
@Builder
public class Ticket {
    private String ticketNumber;
    private ParkingSpot parkingSpot;
    private Date entryDateTime;
    private Attendant attendant;
    private Gate gate;
    private Vehicle vehicle;

    public Ticket(String ticketNumber, ParkingSpot parkingSpot, Date entryDateTime, Attendant attendant, Gate gate, Vehicle vehicle) {
        this.ticketNumber = ticketNumber;
        this.parkingSpot = parkingSpot;
        this.entryDateTime = entryDateTime;
        this.attendant = attendant;
        this.gate = gate;
        this.vehicle = vehicle;
    }
}
