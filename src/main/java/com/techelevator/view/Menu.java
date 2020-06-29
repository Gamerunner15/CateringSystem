package com.techelevator.view;

import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.CateringItem;
import com.techelevator.ConvenientMethods;
import com.techelevator.FileReader;
import com.techelevator.Inventory;
import com.techelevator.LogWriter;
import com.techelevator.MenuLogicHandler;
import com.techelevator.ShoppingCart;

public class Menu {
	private DecimalFormat format = new DecimalFormat("##.00");
	private MenuLogicHandler handler;

	// Constructor
	public Menu(MenuLogicHandler handler) {
		this.handler = handler;
	}

	Scanner userInput = new Scanner(System.in);

	// Main Menu
	public boolean mainMenu() {

		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");
		String response = userInput.nextLine();
		return handler.mainMenuChoices(response);

	}
	// Order Menu (Comes from choosing (2) on Main Menu)
	public void orderMenu() {
		String response = "";
		// We keep looping through until they say Complete Transaction(3).
		while (!response.equals("3")) {

			System.out.println("(1) Add Money");
			System.out.println("(2) Select Products");
			System.out.println("(3) Complete Transaction");
			System.out.println("Current Account Balance: $" + format.format(handler.getBalance()));
			response = userInput.nextLine();
			handler.orderMenuChoices(response);

		}
		return;
	}
	
	//Prints out the current inventory of all items and their prices
	public void printOutInventory() {
		System.out.println(ConvenientMethods.toString("ID", "Item Name", "Price", "Type", "Stock"));
		System.out.println("----------------------------------------------------------");
		handler.finalString();

		}
	
}