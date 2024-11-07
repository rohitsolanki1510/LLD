package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.CoffeeType;
import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;
import com.coffevendingmachine.model.Coffee;

public class PreparationState implements State {
	CoffeeVendingMachine coffeeVendingMachine;
	

	public PreparationState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}

	@Override
	public void coffeeTypeSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receivePayment(double amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelSelection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepare() {
		Coffee coffee=coffeeVendingMachine.getCoffee();
		System.out.println("Preparing Coffee...");
		coffee.prepare();
		coffeeVendingMachine.setState(coffeeVendingMachine.getDispenseState());
		coffeeVendingMachine.getState().dispense();
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		
	}

}
