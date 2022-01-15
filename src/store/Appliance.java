package store;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Appliance extends Product {
	private String model;
	private String productionDate;
	private float weight;
	
	public Appliance(String name, String brand, float price, String model, String productionDate, float weight) {
		super(name, brand, price);
		this.model = model;
		this.productionDate = productionDate;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return getName() + " " + getBrand() + " " + model;
	}

	@Override
	public float getDiscount(LocalDate purchaseDate) {
		float discount = 0;
		float price = getPrice();
		
		DayOfWeek day = purchaseDate.getDayOfWeek();
		String dayOfWeek = day.getDisplayName(TextStyle.SHORT, Locale.getDefault());
		
		if(price > 999 && (dayOfWeek.equals("Sat") || dayOfWeek.equals("Sun"))) {
			discount = 0.05f;
		}
		return discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((productionDate == null) ? 0 : productionDate.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
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
		Appliance other = (Appliance) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (productionDate == null) {
			if (other.productionDate != null)
				return false;
		} else if (!productionDate.equals(other.productionDate))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}
}
