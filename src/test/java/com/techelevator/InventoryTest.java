package com.techelevator;

import org.junit.*;

public class InventoryTest {
	
	private Inventory instance;
	
	
	@Before
	public void before() {
		instance = new Inventory();
	}
	
	@Test
	public void testInitialInventoryAndGetInventory() {
		instance.initialInventory();
		
		Assert.assertEquals("Cake", instance.getInventoryMap().get("D2").getName());
		Assert.assertEquals("Beef and Gravy", instance.getInventoryMap().get("E4").getName());
		Assert.assertEquals("BBQ Ribs", instance.getInventoryMap().get("E3").getName());
		Assert.assertEquals("Beer", instance.getInventoryMap().get("B3").getName());


	}

}
