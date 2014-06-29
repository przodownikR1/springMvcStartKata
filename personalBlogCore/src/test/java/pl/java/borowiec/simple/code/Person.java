package pl.java.borowiec.simple.code;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 16:59:07
 */
public class Person {

	private Cd cd;

	public void setCd(Cd cd) {
		this.cd = cd;
	}

	@Override
	public String toString() {
		return "Person [cd=" + cd + "]";
	}

	
}
