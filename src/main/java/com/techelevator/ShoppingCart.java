package com.techelevator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	private DecimalFormat format = new DecimalFormat("##.00");
	private Map<String, Integer> cart = new LinkedHashMap<String, Integer>();
	private double balance = 0;
	private Inventory inventoryOne;
	
	public ShoppingCart(Inventory inventory) {
		this.inventoryOne = inventory;
		
	}

	
	
	public void addToCart(String itemId, int quantity) {
		Integer realQuantity = new Integer(quantity);
		if(cart.get(itemId) == null) {
			cart.put(itemId, realQuantity);
		} else {
			cart.put(itemId, cart.get(itemId) + realQuantity);
		}
	}
	
	public void resetCart() {
		this.balance = 0;
		cart.clear();
	}
	
	public double addToBalance(double money) {
		balance += money;
		return balance;
	}
	
	public double subtractFromBalance(double money) {
		balance -= money;
		return balance;
	}
	
	
	public double getAmountOwed() {
		Object[] keys = ConvenientMethods.mapToArray(this.cart);
		double totalOwed = 0;
		for (Object key : keys) {
			//Accessing both the cart Map (for quantity) and the original inventory Map(for price).
			double price = inventoryOne.getInventoryMap().get(key).getPrice();
			int quantity = cart.get(key);
			totalOwed += price * quantity;
		
		}
		return totalOwed;
		
	}
	//use original inventory map plus the quantity passed in to us for calculating total price.
	public double getTotalPrice(String id, int quantity) {
		double price = inventoryOne.getInventoryMap().get(id).getPrice();
		double totalPrice = price * quantity;
		return totalPrice;
	}
	
	
	public double getBalance() {
		return balance;
	}



	public Map<String, Integer> getCart() {
		return cart;
	}

	public void setCart(Map<String, Integer> cart) {
		this.cart = cart;
	}
	public String[] getCartItems() {

		return (String[]) ConvenientMethods.mapToArray(cart);
	}
	
	public List<String> finalBill() {
		String[] itemsArray = (String[]) ConvenientMethods.mapToArray(cart);
		List<String> billList = new ArrayList<String>();
		for (String item : itemsArray) {
			int quantity = cart.get(item);
			String type = inventoryOne.getInventoryMap().get(item).getFoodCat();
			String name = inventoryOne.getInventoryMap().get(item).getName();
			String unitPrice = "$" + format.format(inventoryOne.getInventoryMap().get(item).getPrice());
			String totalUnitPrice = "$" + format.format(this.getTotalPrice(item, quantity));
			billList.add(ConvenientMethods.toBillString(quantity, type, name, unitPrice, totalUnitPrice));
			
		}
		return billList;
	}
	
	public String giveChange() {
		double change = this.getBalance();
		double coins  = Math.ceil((change - Math.floor(change)) * 100);
		int bankNotes = (int) (change - (change - Math.floor(change)));
		int twenties = (int) (bankNotes / 20);
		bankNotes = bankNotes % 20;
		int tens = (int) (bankNotes / 10);
		bankNotes = bankNotes % 10;
		int fives = (int) (bankNotes / 5);
		bankNotes = bankNotes % 5;
		int ones = (int)(bankNotes / 1);
		
		int quarters = (int) (coins / 25);
		coins = coins % 25;
		int dimes = (int) (coins / 10);
		coins = coins % 10;
		int nickles = (int) (coins / 5);
		coins = coins % 5;
		int pennies = (int) (coins /1);
		
		return "$20's: " + twenties + " | $10's: " + tens + " | $5's: " + fives + " | $1's: " + ones + " | Quarters: " + quarters + " | Dimes: " + dimes + " | Nickels: " + nickles + " | Pennies: " + pennies;
		
	}

}
