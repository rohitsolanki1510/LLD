package com.elevatorsystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.elevatorsystem.enums.WorkingStatus;
import com.elevatorsystem.model.Elevator;
import com.elevatorsystem.model.Request;

public class ElevatorController {
	private final List<Elevator> elevators;
	private final int noOfFloor;

    public ElevatorController(int numElevators, int capacity,int noOfFloors) {
        elevators = new ArrayList<>();
        this.noOfFloor=noOfFloors;
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(String.valueOf(i + 1), capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
    	if(sourceFloor>=1 && destinationFloor<=noOfFloor) {
	        Elevator optimalElevator = null;
	        while(optimalElevator==null) {
	        	optimalElevator= findElevator(sourceFloor, destinationFloor);
	        }
	        optimalElevator.acceptRequest(new Request(sourceFloor, destinationFloor));
    	}
    }

    private Elevator findElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
        	if(elevator.getWorkingStatus()==WorkingStatus.WORKING && elevator.isAvailable()) {
	            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
	            if (distance < minDistance) {
	                minDistance = distance;
	                optimalElevator = elevator;
	            }
        	}
        }

        return optimalElevator;
    }

}
