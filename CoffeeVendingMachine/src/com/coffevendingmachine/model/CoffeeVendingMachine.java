package com.coffevendingmachine.model;

import java.util.Map;
import java.util.TreeMap;

import com.coffevendingmachine.enums.CoffeeType;
import com.coffevendingmachine.enums.Ingredient;
import com.coffevendingmachine.model.Coffee;
import com.coffevendingmachine.model.state.AcceptPaymentState;
import com.coffevendingmachine.model.state.DispenseState;
import com.coffevendingmachine.model.state.IdleState;
import com.coffevendingmachine.model.state.OutOfServiceState;
import com.coffevendingmachine.model.state.PreparationState;
import com.coffevendingmachine.model.state.SelectionState;
import com.coffevendingmachine.model.state.ShutdownState;
import com.coffevendingmachine.model.state.State;

public class CoffeeVendingMachine {
	Map<Ingredient,Integer> currentIngridients;
	TreeMap<Integer,CoffeeType> menu;
	State state;
	State shutdownState;
	State idleState;
	State selectionState;
	State acceptPaymentState;
	State preparationState;
	State dispenseState;
	State outOfServiceState;
	Coffee coffee;
	Double receivedPaymentAmount=0.0;
	
	public CoffeeVendingMachine(Map<Ingredient, Integer> currentIngridients,
			TreeMap<Integer,CoffeeType> menu) {
		
		this.currentIngridients = currentIngridients;
		this.menu = menu;
		this.idleState=new IdleState(this);
		this.selectionState=new SelectionState(this);
		this.acceptPaymentState=new AcceptPaymentState(this);
		this.preparationState=new PreparationState(this);
		this.dispenseState=new DispenseState(this);
		this.outOfServiceState=new OutOfServiceState(this);
		this.shutdownState=new ShutdownState(this);
		this.state=shutdownState;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void startOrder() {
		state.startOrder();
	}
	
	public void coffeeTypeSelection() {
		state.coffeeTypeSelection();
	}

	public void receivePayment(double amount) {
		state.receivePayment(amount);
	}

	public void cancelSelection() {
		state.cancelSelection();
	}

	public void refill(Map<Ingredient, Integer> ingredients) {
		state.refill(ingredients);
	}
	
	public void turnOn() {
		state.turnOn();
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Map<Ingredient, Integer> getCurrentIngridients() {
		return currentIngridients;
	}

	public TreeMap<Integer,CoffeeType> getMenu() {
		return menu;
	}

	public State getIdleState() {
		return idleState;
	}

	public State getShutdownState() {
		return shutdownState;
	}

	public State getSelectionState() {
		return selectionState;
	}

	public State getAcceptPaymentState() {
		return acceptPaymentState;
	}

	public State getPreparationState() {
		return preparationState;
	}

	public State getDispenseState() {
		return dispenseState;
	}

	public State getOutOfServiceState() {
		return outOfServiceState;
	}

	public Coffee getCoffee() {
		return coffee;
	}
	
	public void displayMenu() {
		//Display Menu
		System.out.println(menu);
	}

	public Double getReceivedPaymentAmount() {
		return receivedPaymentAmount;
	}

	public void setReceivedPaymentAmount(Double receivedPaymentAmount) {
		this.receivedPaymentAmount += receivedPaymentAmount;
	}
	
	public void updateIngredients(Map<Ingredient,Integer> ingridientsUtilized){
		//update ingridients
		System.out.println("Updating Ingredients...");
		if(checkIngredients()) {
			this.state=outOfServiceState;
		}
	}
	
	public boolean checkIngredients(){
		return true;
	}
	
	
	
}
