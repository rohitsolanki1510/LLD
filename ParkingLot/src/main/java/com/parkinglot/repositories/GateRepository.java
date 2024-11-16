package com.parkinglot.repositories;

import com.parkinglot.exception.NotFoundException;
import com.parkinglot.model.Gate;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import static com.parkinglot.constants.ResponseMessages.GATE_NOT_FOUND_MSG;

@Repository
@Getter
public class GateRepository {
    private Map<String , Gate> gateDB=new HashMap<>();


    public Gate getGateByNumber(String gateNumber) throws NotFoundException {
        Gate gate=gateDB.get(gateNumber);
        if(gate==null){
            throw new NotFoundException(GATE_NOT_FOUND_MSG+gateNumber);
        }
        return gate;
    }
}
