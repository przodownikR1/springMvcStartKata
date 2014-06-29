package pl.java.borowiec.simple.code;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 15:32:42
 
 */
public class Book extends Product{
  private int pages;

  

public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(String name, double price) {
	super(name, price);
	// TODO Auto-generated constructor stub
}

public int getPages() {
	return pages;
}

public void setPages(int pages) {
	this.pages = pages;
}

@Override
public String toString() {
	return "Book [pages=" + pages + ", getPages()=" + getPages() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
}


  
}
