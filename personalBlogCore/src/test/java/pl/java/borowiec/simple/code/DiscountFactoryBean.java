package pl.java.borowiec.simple.code;

import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 15:52:21
 
 */
public class DiscountFactoryBean extends AbstractFactoryBean<Product> {
	private Product product;
	private double discount;

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Class getObjectType() {
		return product.getClass();
	}

	protected Product createInstance() throws Exception {
		product.setPrice(product.getPrice() * (1 - discount));
		return product;
	}
}
