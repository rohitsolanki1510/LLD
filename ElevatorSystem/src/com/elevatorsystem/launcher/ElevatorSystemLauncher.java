package com.elevatorsystem.launcher;

import com.elevatorsystem.controller.ElevatorController;

public class ElevatorSystemLauncher {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  ElevatorController controller = new ElevatorController(3, 5,10);

	        controller.requestElevator(5, 10);
	        Thread.sleep(1000);
	        controller.requestElevator(3, 7);
	        Thread.sleep(1000);
	        controller.requestElevator(8, 2);
	        Thread.sleep(1000);
	        controller.requestElevator(1, 9);
	        
	}

}
