package pl.java.borowiec.simple.code;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 15:32:09
 */
public abstract class Product {
	private String name;
	private double price;

	public static final Book BOOK_ONE = new Book("abcBook", 2.5);
	public static final Cd CD_ONE = new Cd("abcCd", 1.5);

	
	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
