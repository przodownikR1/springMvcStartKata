package pl.java.borowiec.aop.service;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 12:08:16
 
 */
public class Customer {
	private String  name ;

	public Customer() {
		super();
	}

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
