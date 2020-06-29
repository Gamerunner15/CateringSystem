package com.techelevator;

import java.text.DecimalFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
	DecimalFormat format = new DecimalFormat("##.00");

	public Map<String, CateringItem> loadItems() {
		//Create Variables
		File importData = new File("cateringsystem.csv");
		List<CateringItem> inventoryList = new ArrayList();
		Map inventory = new LinkedHashMap<String, CateringItem>();

		try (Scanner fileScanner = new Scanner(importData)) {
			//Adding items to a List
			while (fileScanner.hasNextLine()) {
				String[] itemSpecs = fileScanner.nextLine().split("\\|");
				//Creating CateringItems for the first time! putting values in based on the split lines.
				CateringItem item = new CateringItem(itemSpecs[0], itemSpecs[1],Double.valueOf(itemSpecs[2]), itemSpecs[3]);
				inventoryList.add(item);
			}
			//Adding List Items to a Map
				for (CateringItem item : inventoryList) {
					
					inventory.put(item.getItemId(), item);
					
				}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventory;
	}

}
