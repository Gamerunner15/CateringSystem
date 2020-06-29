package com.techelevator;

public class CateringItem {
	
	private String name;
	private double price;
	private String itemId;
	private String foodCat;
	private int quantity;
	
	
	public CateringItem(String itemId, String name, double price, String foodCat) {
		this.name = name;
		this.price = price;
		this.itemId = itemId;
		this.foodCat = foodCat;
		this.quantity = 50;
	}
	
	
	public int decreaseQuantity(int amountToDecrease) {
		this.quantity -= amountToDecrease;
		return quantity;
	}
	
	public String getQuantityString() {
		if(this.getQuantity() == 0) {
			return "SOLD OUT";
		} else {
			return String.valueOf(this.getQuantity());
		}
	}
	
	


	public boolean isSoldOut() {
		if (quantity == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getQuantity() {
		
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getFoodCat() {
		if (foodCat.equals("B")) {
			return "Beverage";
		}else if (foodCat.equals("E")) {
			return "Entree";
		}else if(foodCat.equals("D")) {
			return "Dessert";
		} else {
			return "Appetizer";
		}
		
	}
	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}

}
