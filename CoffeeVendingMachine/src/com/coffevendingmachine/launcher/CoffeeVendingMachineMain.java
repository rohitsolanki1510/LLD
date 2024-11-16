package com.coffevendingmachine.launcher;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.coffevendingmachine.enums.CoffeeType;
import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.launcher.CoffeeVendingMachine;

public class CoffeeVendingMachineMain {

	public static void main(String[] args) {
		Map<Ingredient,Integer> currentIngridients=new HashMap<>();
		TreeMap<Integer,CoffeeType> menu=new TreeMap<>();
		
		
		
		currentIngridients.put(Ingredient.COFFEE, 1000);
		currentIngridients.put(Ingredient.MILK, 1000);
		currentIngridients.put(Ingredient.WATER, 1000);
		currentIngridients.put(Ingredient.SUGAR, 1000);
		currentIngridients.put(Ingredient.CREAM, 1000);
		currentIngridients.put(Ingredient.CHOCOLATE, 1000);
		
		int counter=1;
		menu.put(counter++, CoffeeType.ESPRESSO);
		menu.put(counter++, CoffeeType.CAPPUCCINO);
		menu.put(counter++, CoffeeType.MOCHA);
		menu.put(counter++, CoffeeType.LATTE);
		
		CoffeeVendingMachine coffeeVendingMachine=new CoffeeVendingMachine(currentIngridients, menu);
		coffeeVendingMachine.turnOn();
		coffeeVendingMachine.startOrder();
		coffeeVendingMachine.receivePayment(50);
		
	}

}
