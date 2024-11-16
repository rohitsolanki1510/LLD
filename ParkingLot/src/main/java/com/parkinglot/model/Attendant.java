package com.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Attendant {
    private String name;
    private String employeeId;

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
