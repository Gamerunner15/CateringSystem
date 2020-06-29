package com.techelevator;

import org.junit.*;

public class FileReaderTest {
	
	private FileReader instance;
	
	
	@Before
	public void before() {
		instance = new FileReader();
	}
	
	
	@Test
	public void testLoadItems() {
		
		Assert.assertEquals("Bruschetta", instance.loadItems().get("A4").getName());
		Assert.assertEquals(2.65, instance.loadItems().get("A4").getPrice(), 0);
		Assert.assertEquals("Appetizer", instance.loadItems().get("A4").getFoodCat());
		
		Assert.assertEquals("Cake", instance.loadItems().get("D2").getName());
		Assert.assertEquals(1.80, instance.loadItems().get("D2").getPrice(), 0);
		Assert.assertEquals("Dessert", instance.loadItems().get("D2").getFoodCat());
		
		Assert.assertEquals("Beef and Gravy", instance.loadItems().get("E4").getName());
		Assert.assertEquals(5.15, instance.loadItems().get("E4").getPrice(), 0);
		Assert.assertEquals("Entree", instance.loadItems().get("E4").getFoodCat());
		
		
	}
	
	
	

}
