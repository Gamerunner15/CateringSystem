package com.techelevator;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ConvenientMethods {
	DecimalFormat format = new DecimalFormat("##.00");
	
	//Takes a Map and converts it to a Set, then the Set into a String Array.
	public static Object[] mapToArray(Map map) {
		
		Set keySet = map.keySet();
		
		Object[] keyArray = new String[keySet.size()];
		int i = 0;
		for (Object key : keySet) {
			keyArray[i] = String.valueOf(key);
			i++;

		}
		
		return keyArray;
	}
	
	public static String toString(String itemId, String name, String price, String foodCat, String stock) {
		
		return String.format( "%-3s  %-20s  %-8s  %-10s  %-5s", itemId, name, price, foodCat, stock);
		
	}
	public static String toBillString(int quantity, String type, String name, String unitPrice, String totalUnitPrice) {
	
		return String.format( "%-3s  %-10s  %-20s  %-8s  %-8s", quantity, type, name, unitPrice, totalUnitPrice );
		
	}
	

}
