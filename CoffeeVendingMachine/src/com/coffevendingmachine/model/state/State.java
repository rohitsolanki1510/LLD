package com.coffevendingmachine.model.state;

import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;

public interface State {
	
	void turnOn();
	void startOrder();
	void coffeeTypeSelection();
	void receivePayment(double amount);
	void prepare();
	void dispense();
	void cancelSelection();
	void refill(Map<Ingredient,Integer> ingredients);
	
}
