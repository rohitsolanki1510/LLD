package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.model.CoffeeVendingMachine;
import com.coffevendingmachine.model.Coffee;

public class DispenseState implements State{
	CoffeeVendingMachine coffeeVendingMachine;

	public DispenseState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
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
	public void prepare() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispense() {
		System.out.println("Dispensing Coffee...");
		Coffee coffee=coffeeVendingMachine.getCoffee();
		if(coffeeVendingMachine.getReceivedPaymentAmount()>coffee.getPrice()) {
			System.out.println("Dispensing remaining amount:"+(coffeeVendingMachine.getReceivedPaymentAmount()-coffee.getPrice()));	
		}
		coffeeVendingMachine.updateIngredients(coffee.getIngredients());
		coffeeVendingMachine.setCoffee(null);
		coffeeVendingMachine.setReceivedPaymentAmount(0.00);
		if(coffeeVendingMachine.getState()==this) {
			coffeeVendingMachine.setState(coffeeVendingMachine.getIdleState());
		}
	}

}
