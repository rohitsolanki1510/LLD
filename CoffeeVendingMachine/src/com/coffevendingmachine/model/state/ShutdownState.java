package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.CoffeeType;
import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;

public class ShutdownState implements State {
	CoffeeVendingMachine coffeeVendingMachine;
	
	public ShutdownState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}

	@Override
	public void coffeeTypeSelection() {
	}

	@Override
	public void receivePayment(double amount) {
	}

	@Override
	public void cancelSelection() {
	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
	}

	@Override
	public void turnOn() {
		System.out.println("Turning On Machine.This may take some time...");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Turn On Machine");
		}
        coffeeVendingMachine.setState(coffeeVendingMachine.getIdleState());
	}

	@Override
	public void startOrder() {
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		
	}

}
