package com.elevatorsystem.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.elevatorsystem.enums.Direction;
import com.elevatorsystem.enums.WorkingStatus;

public class Elevator {
	private String name;
	private int capacityInKgs;
	private Direction direction;
	private WorkingStatus workingStatus;
	private int currentFloor;
	private Queue<Request> requests;
	private boolean isAvailable;
	
	public Elevator(String name, int capacityInKgs) {
		this.name = name;
		this.capacityInKgs = capacityInKgs;
		this.requests=new LinkedList<Request>();
		currentFloor=0;
		direction=Direction.UP;
		workingStatus=WorkingStatus.WORKING;
		isAvailable=true;
	}

	public String getName() {
		return name;
	}

	public int getCapacityInKgs() {
		return capacityInKgs;
	}

	public Direction getDirection() {
		return direction;
	}

	public WorkingStatus getWorkingStatus() {
		return workingStatus;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public Queue<Request> getRequests() {
		return requests;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setWorkingStatus(WorkingStatus workingStatus) {
		this.workingStatus = workingStatus;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public synchronized void acceptRequest(Request request) {
		if(requests.size()<capacityInKgs) {
			requests.add(request);
			System.out.println("Request added to elevator "+this.name+" for floor "+request.getDestinationFloor());
            notifyAll();
		}
	}
	
	 public synchronized Request fetchNextRequest() {
		 while (requests.isEmpty()) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    return requests.poll();
	 }
	
	public synchronized void processRequests() {
		 while (true) {
	            while (!requests.isEmpty()) {
	                Request request = fetchNextRequest();
	                processRequest(request);
	            }
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	}
	
	public void processRequest(Request request) {
		System.out.println("Elevator " + name + " reaching floor " + request.getSourceFloor());
		int startFloor=currentFloor;
		int endFloor=request.getSourceFloor();
		isAvailable=false;
		for (int i = startFloor; i <= endFloor; i++) {
	        currentFloor = i;
            System.out.println("Elevator " + name + " reached floor " + currentFloor+" to pickUp  User ");
		}
		startFloor=currentFloor;
		endFloor=request.getDestinationFloor();
		if(currentFloor<endFloor) {
			this.direction=Direction.UP;
			for (int i = startFloor; i <= endFloor; i++) {
                currentFloor = i;
                System.out.println("Elevator " + name + " reached floor " + currentFloor+" carrying User to destination floor "+endFloor);
                try {
                    Thread.sleep(500); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}else {
			this.direction=Direction.DOWN;
			for (int i = startFloor; i >= endFloor; i--) {
                currentFloor = i;
                System.out.println("Elevator " + name + " reached floor " + currentFloor+" carrying User to destination floor "+endFloor);
                try {
                    Thread.sleep(500); // Simulating elevator movement
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}
		  System.out.println("###Elevator " + name + " request Processed for floor : "+endFloor+"###");
		  isAvailable=true;
	}
	
    public void run() {
        processRequests();
    }

}
