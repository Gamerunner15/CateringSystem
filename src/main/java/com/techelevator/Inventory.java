package com.techelevator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
	//Core Storing point of Map
	private Map<String, CateringItem> inventoryMap;

	public String[] getInventoryItems() {

		return (String[]) ConvenientMethods.mapToArray(inventoryMap);
	}

	//This Runs Once At startup
	public void initialInventory() {
		FileReader instance = new FileReader();
		inventoryMap = instance.loadItems();

	}
	
	public boolean itemExists(String itemid) {
		boolean exists = false;
		String[] idList = (String[]) ConvenientMethods.mapToArray(inventoryMap);
		for (String id : idList) {
			if(itemid.equalsIgnoreCase(id)) {
				exists = true;
			}
		}
		return exists;
	}

	public Map<String, CateringItem> getInventoryMap() {
		return inventoryMap;
	}
}