package com.im.core;

import java.util.TreeMap;

import com.im.exceptions.InvalidInputException;
import com.im.exceptions.ItemDoesNotExistException;
import com.im.exceptions.ItemHasAlreadyExistedException;

public class Inventory {
	
	private TreeMap<String, Item> items;
	private double profitSinceLastReport;
	
	public Inventory() {
		this.items = new TreeMap<>();
		this.profitSinceLastReport = 0;
	}
	
	private void checkItemName(String itemName) throws InvalidInputException {
		if (itemName.trim().length() == 0) throw new InvalidInputException();
	}
	
	public void createItem(String itemName, double costPrice, double sellPrice) throws InvalidInputException, ItemHasAlreadyExistedException {
		checkItemName(itemName);
		if (items.containsKey(itemName)) throw new ItemHasAlreadyExistedException();
		items.put(itemName, new Item(itemName, costPrice, sellPrice));
	}

	public void deleteItem(String itemName) throws InvalidInputException, ItemDoesNotExistException {
		checkItemName(itemName);
		if (!items.containsKey(itemName)) throw new ItemDoesNotExistException();
		profitSinceLastReport -= items.remove(itemName).getValue();
	}
	
	public void buyItem(String itemName, int quantity) throws InvalidInputException, ItemDoesNotExistException {
		checkItemName(itemName);
		if (!items.containsKey(itemName)) throw new ItemDoesNotExistException();
		items.get(itemName).setQuantity(quantity);
	}
	
	public void sellItem(String itemName, int quantity) throws InvalidInputException, ItemDoesNotExistException {
		checkItemName(itemName);
		if (!items.containsKey(itemName)) throw new ItemDoesNotExistException();
		profitSinceLastReport += items.get(itemName).getProfitBySelling(quantity);
	}
	
	public void updateSellPrice(String itemName, double sellPrice) throws InvalidInputException, ItemDoesNotExistException {
		checkItemName(itemName);
		if (!items.containsKey(itemName)) throw new ItemDoesNotExistException();
		items.get(itemName).setSellPrice(sellPrice);
	}

	public void printReport() {
		System.out.println("				INVENTORY REPORT				");
		System.out.println(String.format("%20s %20s %20s %20s %20s", "Item Name", "Bought At", "Sold At", "AvailableQty", "Value"));
		System.out.println(String.format("%20s %20s %20s %20s %20s", "---------", "---------", "-------", "------------", "-----"));
		for(Item item : items.values()){
			System.out.println(item.getDetail());
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("Total value %92.2f", getTotalValue()));
		System.out.println(String.format("Profit since previous report %75.2f", profitSinceLastReport));
		this.profitSinceLastReport = 0;
	}
	
	public double getTotalValue() {
		double totalValue = 0;
		for(Item item : items.values()){
			totalValue += item.getValue();
		}
		return totalValue;
	}

}
