package pl.java.borowiec.simple.code;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 16:41:11
 */
public class CreateProduct {

	public static Product createProduct(String productId) {
		if ("isbn".equals(productId)) {
			Book book = new Book();
			book.setName("Book created by factory ....");
			return book;
		} else if ("music".equals(productId)) {
			Cd cd = new Cd();
			cd.setName("Cd created by factory....");
			return cd;
		}
		throw new IllegalArgumentException("Unknown product");
	}

}
