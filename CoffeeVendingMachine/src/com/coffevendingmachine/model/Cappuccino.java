package com.coffevendingmachine.model;

import java.util.HashMap;
import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;

public class Cappuccino extends Coffee {

	@Override
	public void prepare() {
		System.out.println("Preparing Cappuccino");
	}

	@Override
	public double getPrice() {
		return 5;
	}

	@Override
	public Map<Ingredient, Integer> getIngredients() {
		Map<Ingredient, Integer> requiredIngredients=new HashMap<>();
		requiredIngredients.put(Ingredient.COFFEE, 10);
		requiredIngredients.put(Ingredient.MILK, 30);
		requiredIngredients.put(Ingredient.WATER, 60);
		return requiredIngredients;
	}

}
