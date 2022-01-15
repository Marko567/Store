package store;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Clothes extends Product {
	private String size;
	private String color;
	
	public Clothes(String name, String brand, float price, String size, String color) {
		super(name, brand, price);
		this.size = size;
		this.color = color;
	}

	@Override
	public String toString() {
		return getName() + " " + getBrand() + " " + size + " " + color;
	}

	@Override
	public float getDiscount(LocalDate purchaseDate) {
		float discount = 0;
		DayOfWeek day = purchaseDate.getDayOfWeek();
		String dayOfWeek = day.getDisplayName(TextStyle.SHORT, Locale.getDefault());
		if(dayOfWeek.equals("Mon") || dayOfWeek.equals("Tue") || dayOfWeek.equals("Wed") ||
				dayOfWeek.equals("Thu") || dayOfWeek.equals("Fri")) {
			discount = 0.1f;
		}
		return discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Clothes other = (Clothes) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
}
