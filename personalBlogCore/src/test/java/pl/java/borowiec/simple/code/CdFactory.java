package pl.java.borowiec.simple.code;

import org.springframework.beans.factory.FactoryBean;

import com.sun.mail.handlers.image_gif;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 15:58:39
 */
public class CdFactory implements FactoryBean<Cd> {
	private boolean singleton;
	private Cd instance;
	private String name;
	private double price;
	private int capacity;

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	@Override
	public Cd getObject() throws Exception {
		if (!singleton || instance == null) {
			instance = new Cd();
			instance.setCapacity(capacity);
			instance.setName(name);
			instance.setPrice(price);
		}
		return instance;
	}

	@Override
	public Class<?> getObjectType() {
		return Cd.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void setInstance(Cd instance) {
		this.instance = instance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
