package com.coffevendingmachine.model.state;

import java.util.Map;
import java.util.Scanner;

import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;

public class IdleState implements State {
	CoffeeVendingMachine coffeeVendingMachine;

	public IdleState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}

	@Override
	public void coffeeTypeSelection() {
	}

	@Override
	public void receivePayment(double amount) {
		System.out.println("Please select a drink before making Payment!");
	}

	@Override
	public void cancelSelection() {
		System.out.println("Please select a drink before cancelling!");
	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOn() {
		System.out.println("Machine is already turned on!");
	}

	@Override
	public void startOrder() {
		String initiateOrder="";
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("Welcome to Rogers Cofee! :)");
			System.out.print("Would you like to initiate an order.Press Y for Yes");
			initiateOrder=scanner.next();
		}while(!"Y".equalsIgnoreCase(initiateOrder));
		
		coffeeVendingMachine.setState(coffeeVendingMachine.getSelectionState());
		coffeeVendingMachine.getState().coffeeTypeSelection();
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
