package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class SystemSalesReport {

	File salesReport = new File("SystemSalesReport.txt");

	public void writeSystemSales(Inventory inventory, ShoppingCart shoppingCart) {
		if (!salesReport.exists()) {
			try {
				salesReport.createNewFile();
				this.printInitialReport(inventory);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		String[] cartItemsArray = shoppingCart.getCartItems();

		try (FileWriter writer = new FileWriter(salesReport); Scanner fileScanner = new Scanner(salesReport)) {
			PrintWriter salesWriter = new PrintWriter(writer);
			String[] fields = new String[4];
			String[] totalSalesArray = new String[2];
			for (String id : cartItemsArray) {
				while (!fileScanner.hasNextLine()) {
					fields = fileScanner.nextLine().split("\\|");
					if (fields[0].equals(id)) {
						fields[2] = String.valueOf(Integer.valueOf(fields[2]) + shoppingCart.getCart().get(fields[0]));
						fields[3] = String.valueOf(Integer.valueOf(fields[3]) + shoppingCart.getTotalPrice(fields[0], shoppingCart.getCart().get(fields[0])));
					}

				}
			}
			salesWriter.println(totalSalesArray[0] + "|" + totalSalesArray[1] + "|" + totalSalesArray[2] + "|" + "$"
					+ totalSalesArray[3]);

			while (!fileScanner.hasNextLine()) {
				totalSalesArray = fileScanner.nextLine().split(" \\= ");
				if (totalSalesArray[0].equals("TOTAL SALES")) {
					totalSalesArray[1] = String.valueOf(shoppingCart.getAmountOwed());

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printInitialReport(Inventory inventory) {
		String[] inventoryArray = inventory.getInventoryItems();
		Map<String, CateringItem> inventoryMap = inventory.getInventoryMap();
		try  {
			FileWriter writer = new FileWriter(new File("SystemSalesReport.txt"));
			PrintWriter salesWriter = new PrintWriter(writer);
			for (String item : inventoryArray) {
				salesWriter.println(item + "|" + inventoryMap.get(item).getName() + "|" + "0" + "|" + "$" + "0");
			}
			salesWriter.println("TOTAL SALES = 0");
			salesWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
