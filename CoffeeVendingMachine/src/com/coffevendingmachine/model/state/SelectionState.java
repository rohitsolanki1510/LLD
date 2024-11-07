package com.coffevendingmachine.model.state;

import java.util.Map;
import java.util.Scanner;

import com.coffevendingmachine.enums.CoffeeType;
import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;
import com.coffevendingmachine.model.Coffee;
import com.coffevendingmachine.model.CoffeeFactory;

public class SelectionState implements State {
	CoffeeVendingMachine coffeeVendingMachine;
	
	public SelectionState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}

	@Override
	public void coffeeTypeSelection() {
		coffeeVendingMachine.displayMenu();
        System.out.print("Please select your the type of Coffee you'd like to drink: ");
        try (Scanner scanner = new Scanner(System.in)) {
			int selection= scanner.nextInt();
			Coffee coffee=CoffeeFactory.getCoffee(selection);
			System.out.println("Please pay $"+coffee.getPrice());
			coffeeVendingMachine.setCoffee(coffee);
		}
        coffeeVendingMachine.setState(coffeeVendingMachine.getAcceptPaymentState());
	}

	@Override
	public void receivePayment(double amount) {
		 System.out.print("Please select your type of Coffee before doing payment ");
	}

	@Override
	public void cancelSelection() {
		coffeeVendingMachine.setState(coffeeVendingMachine.getIdleState());
	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
		System.out.print("Operation cannot be performed at this moment");
	}

	@Override
	public void turnOn() {
		System.out.println("Machine is already turned on!");		
	}

	@Override
	public void startOrder() {
		System.out.print("Select cancel to start over again!");		
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
