package com.parkinglot.model;

import com.parkinglot.enums.GateType;
import com.parkinglot.enums.OperationalStatus;
import com.parkinglot.enums.SpotStatus;
import com.parkinglot.enums.VehicleType;
import com.parkinglot.repositories.GateRepository;
import com.parkinglot.repositories.ParkingLotRepository;
import com.parkinglot.repositories.TicketRepository;
import com.parkinglot.repositories.VehicleRepository;
import com.parkinglot.service.TicketService;
import com.parkinglot.strategy.AllotmentStrategy;
import com.parkinglot.strategy.FindFirstSpotAllotmentStrategy;
import com.parkinglot.strategy.HourlyPricingStrategy;
import com.parkinglot.strategy.PricingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ParkingLot {
    private String name;
    private List<Floor> floors;
    private List<Gate> gates;
    private OperationalStatus operationalStatus;
    private PricingStrategy pricingStrategy;
    private AllotmentStrategy allotmentStrategy;

    public ParkingLot(){

    }

}
