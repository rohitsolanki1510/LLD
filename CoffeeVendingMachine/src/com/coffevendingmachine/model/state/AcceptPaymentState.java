package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;
import com.coffevendingmachine.model.Coffee;

public class AcceptPaymentState implements State {
	CoffeeVendingMachine coffeeVendingMachine;
	
	public AcceptPaymentState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}
	
	@Override
	public void coffeeTypeSelection() {
		System.out.println("Drink already selected! To change preference Cancel your selection and select again ");
	}


	@Override
	public void receivePayment(double amount) {
		coffeeVendingMachine.setReceivedPaymentAmount(amount);
		Coffee coffe=coffeeVendingMachine.getCoffee();
		if(coffe!=null && coffe.getPrice()>coffeeVendingMachine.getReceivedPaymentAmount()) {
			System.out.println("Please pay the remaining amount:"+(coffeeVendingMachine.getCoffee().getPrice()-coffeeVendingMachine.getReceivedPaymentAmount()));
		}else {
			coffeeVendingMachine.setState(coffeeVendingMachine.getPreparationState());
			coffeeVendingMachine.getState().prepare();
		}
	}

	@Override
	public void cancelSelection() {
		System.out.println("Drink Cancelled");
		coffeeVendingMachine.setState(coffeeVendingMachine.getIdleState());
	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
		System.out.println("Operation Refill not allowed at this stage");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		
	}

	
}
