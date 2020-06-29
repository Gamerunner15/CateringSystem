package com.techelevator;

import org.junit.*;

public class ConvenientMethodsTest {
	
	private ConvenientMethods instance;
	
	@Before
	public void before() {
		instance  = new ConvenientMethods();
	}
	
	@Test
	public void testMapToArray() {
		Inventory inventory = new Inventory();
		inventory.initialInventory();
		
		
		Assert.assertEquals("B1", instance.mapToArray(inventory.getInventoryMap())[0]);
		Assert.assertEquals("B2", instance.mapToArray(inventory.getInventoryMap())[1]);
		Assert.assertEquals("A3", instance.mapToArray(inventory.getInventoryMap())[7]);

	}
	
	@Test
	public void testToString() {
		String itemId = "D2";
		String name = "Cake";
		String price = "$1.80";
		String foodCat = "D";
		String stock = "50";
		
		Assert.assertEquals(String.format( "%-3s  %-20s  %-8s  %-10s  %-5s", itemId, name, price, foodCat, stock), instance.toString(itemId, name, price, foodCat, stock));

	}
	
	@Test
	public void testToBillString() {
		int quantity = 15;
		String name = "Cake";
		String unitPrice = "$1.80";
		String type = "Dessert";
		String totalUnitPrice = "$27.00";
		
		Assert.assertEquals(String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", quantity, type, name, unitPrice, totalUnitPrice ), instance.toBillString(quantity, type, name, unitPrice, totalUnitPrice));

	}
	
	
	

}
