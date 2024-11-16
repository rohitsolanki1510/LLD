package com.parkinglot.service;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.exception.NotFoundException;
import com.parkinglot.exception.ParkingSpotNotAvailableException;
import com.parkinglot.model.*;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.strategy.AllotmentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class TicketService {
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;
    private AllotmentStrategy allotmentStrategy;

    @Autowired
    public TicketService(ParkingLotRepository parkingLotRepository,
                         VehicleRepository vehicleRepository,
                         GateRepository gateRepository,
                         TicketRepository ticketRepository,
                         AllotmentStrategy allotmentStrategy) {

        this.parkingLotRepository=parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository=ticketRepository;
        this.allotmentStrategy=allotmentStrategy;
    }

    public Ticket generateTicket(String vehicleNumber,
                                 VehicleType vehicleType,
                                 String parkingLotId,
                                 String gateId) throws NotFoundException, ParkingSpotNotAvailableException {
        Vehicle vehicle=null;
        Gate gate=null;
        Ticket ticket=null;
        ParkingLot parkingLot=parkingLotRepository.getParkingLotById(parkingLotId);
        gate=gateRepository.getGateByNumber(gateId);
        try{
            vehicle=vehicleRepository.getVehicleByNumber(vehicleNumber);
        }catch (NotFoundException notFoundException){
            System.out.println("Vehicle not found.Creating a new vehicle object");
            vehicle=new Vehicle(vehicleNumber,vehicleType);
            vehicleRepository.saveVehicle(vehicleNumber,vehicle);
        }

        ParkingSpot parkingSpot=allotmentStrategy.allotParkingSpot(parkingLot,vehicle);

        ticket= Ticket.builder()
                .ticketNumber(UUID.randomUUID().toString())
                .entryDateTime(new Date())
                .attendant(gate.getAttendant())
                .gate(gate)
                .vehicle(vehicle)
                .parkingSpot(parkingSpot)
                .build();

        ticketRepository.createTicket(ticket);

        return ticket;
    }
}
