package pl.java.borowiec.simple.code;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 15:39:05
 
 */
public class Cd extends Product{
	private int capacity;

	
	public Cd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cd(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Cd [capacity=" + capacity + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}

}
