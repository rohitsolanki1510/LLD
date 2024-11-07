package com.coffevendingmachine.model;

public class CoffeeFactory {

	
	public static Coffee getCoffee(Integer selection) {
		switch(selection) {
			case 1: return new Espresso();
			default:
			
			case 2: return new Cappuccino();
			
			case 3:return new Mocha();
			
			case 4: return new Latte();
		}
	}
}
