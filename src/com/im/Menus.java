package com.im;

import java.util.Scanner;

import com.im.core.Inventory;
import com.im.exceptions.InvalidInputException;
import com.im.exceptions.ItemDoesNotExistException;
import com.im.exceptions.ItemHasAlreadyExistedException;

public class Menus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Inventory inventory = new Inventory();
		while (true) {
			System.out.println("Please enter a command and press ENTER to process (Enter help for helps):");
			try {
				String command[] = sc.nextLine().split("\\s+");
				switch (command[0].toLowerCase()) {
				case "create":
					String itemName = command[1].toLowerCase();
					double costPrice = Double.parseDouble(command[2]);
					double sellPrice = Double.parseDouble(command[3]);
					inventory.createItem(itemName, costPrice, sellPrice);
					System.out.println("Item is created.");
					break;
				case "delete":
					itemName = command[1].toLowerCase();
					inventory.deleteItem(itemName);
					System.out.println("Item is deleted.");
					break;
				case "updatebuy":
					itemName = command[1].toLowerCase();
					int quantity = Integer.parseInt(command[2]);
					inventory.buyItem(itemName, quantity);
					System.out.println("Buying is processed.");
					break;
				case "updatesell":
					itemName = command[1].toLowerCase();
					quantity = Integer.parseInt(command[2]);
					inventory.sellItem(itemName, quantity);
					System.out.println("Selling is processed.");
					break;
				case "updatesellprice":
					itemName = command[1].toLowerCase();
					sellPrice = Double.parseDouble(command[2]);
					inventory.updateSellPrice(itemName, sellPrice);
					break;
				case "report":
					inventory.printReport();
					break;
				case "help":
					System.out.println("Command menus:");
					System.out.println("create itemName costPrice sellingPrice");
					System.out.println("delete itemName");
					System.out.println("updateBuy itemName quantity");
					System.out.println("updateSell itemName quantity");
					System.out.println("updateSellPrice itemName newSellPrice");
					System.out.println("report");
					break;
				default:
					throw new InvalidInputException();
				}
			} catch (InvalidInputException | NullPointerException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid input!");
			} catch (ItemHasAlreadyExistedException | ItemDoesNotExistException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("-------------------------------------------------------------------------------------------------");
		}
	}

}
