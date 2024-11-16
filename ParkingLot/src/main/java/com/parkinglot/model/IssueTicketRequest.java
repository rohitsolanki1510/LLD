package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

public class IssueTicketRequest {
    private String parkingLotNumber;
    private String gateNumber;
    private String vehicleNumber;
    private String vehicleType;


    public String getParkingLotNumber() {
        return parkingLotNumber;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
