package store;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Food extends Product {
	private String expirationDate;
	
	public Food(String name, String brand, float price, String expirationDate) {
		super(name, brand, price);
		this.expirationDate = expirationDate;
	}
	
	
	public LocalDate getExpirationDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate expirationDate = LocalDate.parse(this.expirationDate, formatter);
		return expirationDate;
	}


	@Override
	public String toString() {
		return getName() + " - " + getBrand();
	}

	@Override
	public float getDiscount(LocalDate purchaseDate) {
		float discount = 0;
		long daysBetween = ChronoUnit.DAYS.between(purchaseDate, getExpirationDate());
		if(daysBetween == 0) {
			discount = 0.5f;
			return discount;
		}
		if(daysBetween > 0 && daysBetween <= 5) {
			discount = 0.1f;
			return discount;
		}
		return discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		return true;
	}
}