package com.techelevator;

import org.junit.*;

public class CateringItemTest {
	
	private CateringItem instance;
	
	
	
	
	@Test
	public void testD2() {
		instance = new CateringItem("D2", "Cake", 2.50, "D");
		Assert.assertEquals(45, instance.decreaseQuantity(5));
		Assert.assertEquals("Dessert", instance.getFoodCat());

		
	}
	
	@Test
	public void testE4() {
		instance = new CateringItem("E4", "Beef and Gravy", 5.15, "E");
		Assert.assertEquals(25, instance.decreaseQuantity(25));
		Assert.assertEquals(-30, instance.decreaseQuantity(55));
		Assert.assertEquals("Entree", instance.getFoodCat());
		
	}

}
