package store;

import java.util.HashMap;
import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		//map represents cart, product and amount
		HashMap<Product, Float> cart = new HashMap<Product, Float>();
		
		Product apples = new Food("apples", "brandA", 1.5f, "2022-01-16");
		Product milk = new Beverage("milk", "brandB", 0.99f, "2022-02-02");
		Product tshirt = new Clothes("T-shirt", "bradnC", 15.99f, "M", "violet");
		Product appliance = new Appliance("laptop", "brandL", 2345.f, "ModelL", "2021-03-03", 1.125f);
		
		Cashier cashier = new Cashier();
		
		cart.put(apples, 2.45f);
		cart.put(milk, 3.0f);
		cart.put(tshirt, 2.0f);
		cart.put(appliance, 1.0f);
		
		LocalDateTime purchaseDateAndTime = LocalDateTime.now();
		
		cashier.printReceipt(cart, purchaseDateAndTime);
	}

}
