package com.im.core;

public class Item {
	private String name;
	private double costPrice;
	private double sellPrice;
	private int quantity;
	public Item(String name, double costPrice, double sellPrice) {
		this.name = name;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
		this.quantity = 0;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public double getProfitBySelling(int sold) {
		if (quantity < sold) {
			
		} else {
			quantity -= sold;
		}
		return (sellPrice-costPrice)*sold;
	}
	
	public double getValue() {
		return costPrice*quantity;
	}
	
	public String getDetail() {
		return String.format("%20s %20.2f %20.2f %20d %20.2f", name, costPrice, sellPrice, quantity, getValue());
	}
}
