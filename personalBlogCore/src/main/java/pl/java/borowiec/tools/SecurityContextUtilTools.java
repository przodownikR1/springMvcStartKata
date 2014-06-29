package pl.java.borowiec.tools;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 12:40:03
 */
public final class SecurityContextUtilTools {

	private SecurityContextUtilTools() {
		throw new AssertionError();
	}

	/**
	 * Get security user whom is already logged
	 * 
	 * @return get current logged user
	 */
	public static User getCurrentUser() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication authentication = ctx.getAuthentication();
		if (authentication != null && authentication.getPrincipal() != null) {
			try {
				User user = (User) authentication.getPrincipal();
				return user;
			} catch (ClassCastException cce) {
				return null;
			}

		}

		return null;
	}

}