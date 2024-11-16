package com.parkinglot.model;

import com.parkinglot.enums.SpotStatus;
import com.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParkingSpot {
    private String number;
    private SpotStatus spotStatus;
    private VehicleType vehicleType;
    private String floorName;

}
