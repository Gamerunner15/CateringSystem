package com.techelevator;

import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class LogWriter {
	private File file;
	private DecimalFormat format = new DecimalFormat("##.00");
	private ShoppingCart cart;
	private Inventory inventory;

	// We create the file when the object is constructed to avoid overwriting.
	public LogWriter(File file, ShoppingCart cart, Inventory inventory) {
		this.inventory = inventory;
		this.cart = cart;
		this.file = file;
		try {
			file.createNewFile();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addMoneyLog(double balanceIncrease) {

		try {
			// Creating a FileWriter. "true" indicates appending to what is already there.
			FileWriter writer = new FileWriter(file, true);
			// We nest the FileWriter in a PrintWriter for convenient functions.
			PrintWriter logWriter = new PrintWriter(writer);
			logWriter.print(this.getDateFormat()); // --> this calls the internal method we made to get a Date String.
			logWriter.print(" " + "ADD MONEY: $" + format.format(balanceIncrease) + " " + "$"
					+ format.format(cart.getBalance()));
			logWriter.println("");
			logWriter.close(); // --> Make sure we close writers after we're done! Because we didn't use a
								// try(with Resources).

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPurchaseLog(CateringItem item, int quantity) {

		try {
			FileWriter writer = new FileWriter(file, true);
			PrintWriter logWriter = new PrintWriter(writer);
			// We use a method from ShoppingCart to calculate the full price of a number of
			// one item.
			double fullPrice = cart.getTotalPrice(item.getItemId(), quantity);

			logWriter.print(this.getDateFormat());
			// We print many things here. The quantity of items, then name, its ID, how much
			// it cost, and the total balance afterward.
			logWriter.print(" " + quantity + " " + item.getName() + " " + item.getItemId() + " $"
					+ format.format(fullPrice) + " $" + format.format(cart.getBalance()));
			logWriter.println("");

			logWriter.close(); // --> Make sure we close writers after we're done! Because we didn't use a
								// try(with Resources).

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getChangeLog() {
		try {
			FileWriter writer = new FileWriter(file, true);
			PrintWriter logWriter = new PrintWriter(writer);
			double change = cart.getBalance() - cart.getAmountOwed();

			logWriter.print(this.getDateFormat());

			logWriter.print(
					" " + "GIVE CHANGE: $" + format.format(change) + " " + "$" + format.format(cart.getBalance()));
			logWriter.println("");

			logWriter.close(); // --> Make sure we close writers after we're done! Because we didn't use a
								// try(with Resources).

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method just for making a String that contains the date and time.
	public String getDateFormat() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatter.format(date);
	}

}
