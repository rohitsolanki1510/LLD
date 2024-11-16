package com.parkinglot.strategy;

import com.parkinglot.enums.VehicleType;
import com.parkinglot.exception.ParkingSpotNotAvailableException;
import com.parkinglot.model.Floor;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;

import java.util.List;

public interface AllotmentStrategy {
    ParkingSpot allotParkingSpot(ParkingLot parkingLot, Vehicle vehicle) throws ParkingSpotNotAvailableException;
}
