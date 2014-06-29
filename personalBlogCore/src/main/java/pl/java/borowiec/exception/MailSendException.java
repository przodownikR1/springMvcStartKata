package pl.java.borowiec.exception;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 23:55:32
 */
public class MailSendException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729611192841117901L;

	public MailSendException() {
		super();
	}

	public MailSendException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailSendException(String message) {
		super(message);

	}

	public MailSendException(Throwable cause) {
		super(cause);
	}

}
