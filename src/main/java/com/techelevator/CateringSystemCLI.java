package com.techelevator;

import java.io.File;

import com.techelevator.view.Menu;

public class CateringSystemCLI {

	public static void main(String[] args) {
		// creating all the instances we'll need to pass to others
		Inventory inventoryOne = new Inventory();
		inventoryOne.initialInventory();
		File file = new File("Log.txt");
		ShoppingCart shoppingCartOne = new ShoppingCart(inventoryOne);
		LogWriter logWriter = new LogWriter(file, shoppingCartOne, inventoryOne);
		MenuLogicHandler handler = new MenuLogicHandler(inventoryOne, shoppingCartOne, logWriter);
		Menu menu = new Menu(handler);
		handler.setMenu(menu);
		
		
		// mainMenu can return a false to break this loop.
		boolean continueMenu = true;
		while (continueMenu == true) {
			continueMenu = menu.mainMenu();
		}
	}

}
