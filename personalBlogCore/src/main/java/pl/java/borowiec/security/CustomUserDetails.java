package pl.java.borowiec.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 09-04-2013 09:11:41
 */
public class CustomUserDetails extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String name;
	private boolean newUser;

	public CustomUserDetails(String username, Collection<GrantedAuthority> authorities) {
		super(username, "unused", authorities);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
