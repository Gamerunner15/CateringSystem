package com.techelevator;

import org.junit.*;

public class ShoppingCartTest {
	
	private ShoppingCart instance;
	private Inventory inventory = new Inventory();
	
	
	
	@Before
	public void before() {
		instance = new ShoppingCart(inventory);
		
	}
	
	@Test
	public void testAddToCart() {
		Integer quantity = new Integer(15);
		instance.addToCart("D2", 15);
		Assert.assertEquals(quantity, instance.getCart().get("D2"));
	}
	
	@Test
	public void testAddToBalance() {
		
		Assert.assertEquals(500, instance.addToBalance(500), 1e-8);
		Assert.assertEquals(900, instance.addToBalance(400), 1e-8);
		Assert.assertEquals(923.89, instance.addToBalance(23.89), 1e-8);
		
	}
	
	@Test
	public void testSubtractFromBalance() {
		instance.addToBalance(5000);
		
		Assert.assertEquals(4976.23, instance.subtractFromBalance(23.77), 1e-8);
		Assert.assertEquals(4270.23, instance.subtractFromBalance(706), 1e-8);
		Assert.assertEquals(270.23, instance.subtractFromBalance(4000), 1e-8);
		
	}
	
	@Test
	public void testGetAmountOwed() {
		Inventory inventory = new Inventory();
		inventory.initialInventory();
		
		instance.addToCart("D2", 15);
		Assert.assertEquals(27, instance.getAmountOwed(), 1e-8);
		
		instance.addToCart("E2", 10);
		Assert.assertEquals(121.5, instance.getAmountOwed(), 1e-8);

		instance.addToCart("B4", 9);
		Assert.assertEquals(142.65, instance.getAmountOwed(), 1e-8);

	}
	
	@Test
	public void testGetTotalPrice() {
		Inventory inventory = new Inventory();
		inventory.initialInventory();
		
		Assert.assertEquals(27, instance.getTotalPrice("D2", 15), 1e-8);
		Assert.assertEquals(30, instance.getTotalPrice("B1", 20), 1e-8);
		Assert.assertEquals(249, instance.getTotalPrice("A3", 60), 1e-8);

	}
	
	@Test
	public void testFinalBill() {
		Inventory inventory = new Inventory();
		inventory.initialInventory();
		
		
		instance.addToCart("D2", 15);
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 15, "Dessert", "Cake", "$1.80", "$27.00"), instance.finalBill().get(0));
		instance.addToCart("E2", 15);
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 15, "Dessert", "Cake", "$1.80", "$27.00"), instance.finalBill().get(0));
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 15, "Entree", "Pork Loin", "$9.45", "$141.75"), instance.finalBill().get(1));
		instance.addToCart("B2", 10);
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 15, "Dessert", "Cake", "$1.80", "$27.00"), instance.finalBill().get(0));
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 15, "Entree", "Pork Loin", "$9.45", "$141.75"), instance.finalBill().get(1));
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", 10, "Beverage", "Wine", "$3.05", "$30.50"), instance.finalBill().get(2));

		
	}
	
	
	@Test
	public void testGiveChange() {
		Inventory inventory = new Inventory();
		inventory.initialInventory();
		instance.addToBalance(5000);
		instance.addToCart("D2", 15);
		instance.addToCart("E2", 15);
		instance.addToCart("B2", 10);
		instance.subtractFromBalance(27);
		instance.subtractFromBalance(141.75);
		instance.subtractFromBalance(30.50);

		
		Assert.assertEquals("$20's: " + "240" + " | $10's: " + "0" + " | $5's: " + "0" + " | $1's: " + "0" + " | Quarters: " + "3" + " | Dimes: " + "0" + " | Nickels: " + "0" + " | Pennies: " + "0", instance.giveChange());
		
		
	}
	

}
