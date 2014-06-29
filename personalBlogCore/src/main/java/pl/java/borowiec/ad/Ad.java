package pl.java.borowiec.ad;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 12-04-2013 00:38:30
 */
public class Ad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2282361258807787890L;
	private String name;
	private String content;
	private BigDecimal price;
	private int minTime;

	public Ad(String name, String content, BigDecimal price, int minTime) {
		super();
		this.name = name;
		this.content = content;
		this.price = price;
		this.minTime = minTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getMinTime() {
		return minTime;
	}

	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}

	@Override
	public String toString() {
		return "Ad [name=" + name + ", content=" + content + ", price=" + price + ", minTime=" + minTime + "]";
	}

}
