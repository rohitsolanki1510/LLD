package com.parkinglot.model;

import com.parkinglot.enums.GateType;
import com.parkinglot.enums.OperationalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Gate {
    private String gateNumber;
    private GateType gateType;
    private OperationalStatus status;
    private Attendant attendant;

}
