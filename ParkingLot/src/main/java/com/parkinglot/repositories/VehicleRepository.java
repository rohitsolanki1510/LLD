package com.parkinglot.repositories;

import com.parkinglot.exception.NotFoundException;
import com.parkinglot.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.parkinglot.constants.ResponseMessages.VEHICLE_NOT_FOUND_MSG;

@Repository
public class VehicleRepository {
    private Map<String, Vehicle> vehicleDB=new HashMap<>();

    public Vehicle getVehicleByNumber(String vehicleNumber) throws NotFoundException {


        if(vehicleDB.containsKey(vehicleNumber)){
            return vehicleDB.get(vehicleNumber);
        }else{
             throw new NotFoundException(VEHICLE_NOT_FOUND_MSG+vehicleNumber);
        }
    }

    public Vehicle saveVehicle(String vehicleNumber  ,Vehicle vehicle){
        vehicleDB.put(vehicleNumber,vehicle);
        return vehicle;
    }

}
