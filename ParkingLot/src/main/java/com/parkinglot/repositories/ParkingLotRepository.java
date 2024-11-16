package com.parkinglot.repositories;

import com.parkinglot.exception.NotFoundException;
import com.parkinglot.model.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.parkinglot.constants.ResponseMessages.NO_PARKING_LOT_FOUND_MSG;

@Repository
public class ParkingLotRepository {
    private Map<String, ParkingLot> parkingLotMap = new HashMap<>();

    public Map<String, ParkingLot> getParkingLotMap() {
        return parkingLotMap;
    }

    public ParkingLot getParkingLotById(String id) throws NotFoundException {
        if (parkingLotMap.containsKey(id)) {
            return parkingLotMap.get(id);
        }
        throw new NotFoundException(NO_PARKING_LOT_FOUND_MSG+id);
    }

}
