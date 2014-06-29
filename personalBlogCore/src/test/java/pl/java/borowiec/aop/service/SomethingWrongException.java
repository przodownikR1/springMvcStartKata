package pl.java.borowiec.aop.service;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 12:10:03
 */
public class SomethingWrongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4961058271713932097L;

	public SomethingWrongException() {
		super();

	}

	public SomethingWrongException(String message, Throwable cause) {
		super(message, cause);

	}

	public SomethingWrongException(String message) {
		super(message);

	}

	public SomethingWrongException(Throwable cause) {
		super(cause);

	}

}
