package store;

import java.time.LocalDate;

public abstract class Product {
	private String name;
	private String brand;
	private float price;
	
	public Product(String name, String brand, float price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public float getPrice() {
		return price;
	}
	public abstract float getDiscount(LocalDate purchaseDate);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	
}
