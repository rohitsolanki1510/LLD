package com.parkinglot.strategy;

import com.parkinglot.enums.SpotStatus;
import com.parkinglot.exception.ParkingSpotNotAvailableException;
import com.parkinglot.model.Floor;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Vehicle;

import java.util.List;

import static com.parkinglot.constants.ResponseMessages.PARKING_SPOT_NOT_AVAILABLE_MSG;

public class FindFirstSpotAllotmentStrategy implements  AllotmentStrategy{

    @Override
    public ParkingSpot allotParkingSpot(ParkingLot parkingLot, Vehicle vehicle) throws ParkingSpotNotAvailableException {
        for(Floor floor:parkingLot.getFloors()){
            for(ParkingSpot spot: floor.getParkingSpots()){
                if(SpotStatus.VACANT==spot.getSpotStatus() && spot.getVehicleType()==vehicle.getVehicleType()){
                    return spot;
                }
            }
        }

       throw new ParkingSpotNotAvailableException(PARKING_SPOT_NOT_AVAILABLE_MSG);
    }
}
