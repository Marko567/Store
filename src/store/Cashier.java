package store;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.time.LocalDate;


public class Cashier {
	
	public void printReceipt(HashMap<Product, Float> cart, LocalDateTime purchaseDateAndTime) {
		DecimalFormat df = new DecimalFormat("$###.##");
		DecimalFormat percentage = new DecimalFormat("#%");
		
		String receipt = "Date: ";
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateAndTime = purchaseDateAndTime.format(formatter);
		
		receipt += formattedDateAndTime + "\n\n" + "---Products---\n\n";
		
		LocalDate purchaseDate = purchaseDateAndTime.toLocalDate();
		
		float subtotal = 0;
		float totalDiscount = 0;
		float total = 0;
		
		for(Product cartProduct : cart.keySet()) {
			receipt += cartProduct.toString() + "\n";
			
			float price = cartProduct.getPrice();
			Float amount = cart.get(cartProduct);
			float totalPrice = amount * price;
			
			subtotal += totalPrice;
			
			receipt += amount.toString() + " x " + df.format(price) + " = " + df.format(totalPrice) + "\n";
			
			float discount = cartProduct.getDiscount(purchaseDate);
			
			if(discount != 0) {
				receipt += "#discount " + percentage.format(discount)+" " + "-" + df.format(totalPrice * discount);
				totalDiscount += totalPrice * discount;
			}
			receipt += "\n\n";
		}
		total = subtotal - totalDiscount;
		receipt += "-------------------------------------------------\n\n\n";
		receipt += "SUBTOTAL: " + df.format(subtotal) + "\n";
		receipt += "DISCOUNT: " + "-" +df.format(totalDiscount) + "\n\n";
		receipt += "TOTAL: " + df.format(total);
		
		System.out.println(receipt);
	}
}
