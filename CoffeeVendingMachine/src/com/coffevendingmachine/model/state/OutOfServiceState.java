package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.model.CoffeeVendingMachine;

public class OutOfServiceState implements State {
	CoffeeVendingMachine coffeeVendingMachine;

	public OutOfServiceState(CoffeeVendingMachine coffeeVendingMachine) {
		this.coffeeVendingMachine = coffeeVendingMachine;
	}

	@Override
	public void receivePayment(double amount) {
	}

	@Override
	public void cancelSelection() {

	}

	@Override
	public void refill(Map<Ingredient, Integer> ingredients) {
		coffeeVendingMachine.updateIngredients(ingredients);
	}

	@Override
	public void turnOn() {
	}

	@Override
	public void startOrder() {
	}

	@Override
	public void coffeeTypeSelection() {
	}

	@Override
	public void prepare() {
	}

	@Override
	public void dispense() {
	}

}
