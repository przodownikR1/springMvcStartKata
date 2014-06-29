package pl.java.borowiec.exception;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 23:55:26
 */
public class ImageUploadException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ImageUploadException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageUploadException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ImageUploadException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ImageUploadException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
