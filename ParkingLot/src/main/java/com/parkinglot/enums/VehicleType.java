package com.parkinglot.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Arrays;

public enum VehicleType {
    TWO_WHEELER("TWO_WHEELER"),
    FOUR_WHEELER("FOUR_WHEELER"),
    HEAVY_VEHICLE("HEAVY_VEHICLE");

    private String value;

    VehicleType(String value) {
        this.value = value;
    }

    public VehicleType fromValue(String vehicleType){
        return Arrays.stream(values())
                .filter(value->value.toString().equals(vehicleType))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "value='" + value + '\'' +
                '}';
    }
}
