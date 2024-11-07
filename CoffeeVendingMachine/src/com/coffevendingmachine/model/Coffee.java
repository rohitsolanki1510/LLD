package com.coffevendingmachine.model;

import java.util.Map;

import com.coffevendingmachine.enums.Ingredient;

public abstract class Coffee {
	protected double price;
	protected Map<Ingredient,Integer> ingredients;
	
	public abstract void prepare();

	public abstract double getPrice();
	public abstract Map<Ingredient, Integer> getIngredients();	
	
}
