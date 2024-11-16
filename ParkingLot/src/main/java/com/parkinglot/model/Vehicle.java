package com.parkinglot.model;

import com.parkinglot.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private String vehicleRegistrationNumber;
    private VehicleType vehicleType;

}
