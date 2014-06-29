package pl.java.borowiec.def;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 10-03-2013 23:23:00
 */
public interface RegExp {
	String IP_REGEX = "\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b"; //$NON-NLS-1$
	String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$"; //$NON-NLS-1$
	String PESEL_REGEX = "\\d{11}"; //$NON-NLS-1$
	String POSTAL_CODE_REGEX = "^\\d{2}-\\d{3}$"; //$NON-NLS-1$
	String PHONE_REGEX = "^(([+]\\d{11})|([0]?\\d{9})|((([0]?)|([+]\\d{2}[ ]))?\\d{2}[ ]\\d{3}[ ]\\d{2}[ ]\\d{2})|(([+]\\d{2}[ ])?\\d{3}[ ]\\d{3} \\d{3}))$"; //$NON-NLS-1$
	String ALPHA_NUMERIC = "^[A-Z0-9-]+$";//can only contain alpha, '.', '-' and ' ' characters" //$NON-NLS-1$
	String NUMBERIC_CHARACTER = "^[0-9]+$"; //$NON-NLS-1$
}
