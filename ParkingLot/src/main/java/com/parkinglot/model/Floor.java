package com.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor {
    private String name;
    private List<ParkingSpot> parkingSpots;

    public Floor(String name) {
        this.name = name;
        parkingSpots=new ArrayList<>();
    }
}
