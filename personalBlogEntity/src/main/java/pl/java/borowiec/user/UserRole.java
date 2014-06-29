package pl.java.borowiec.user;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.java.borowiec.common.CommonEntity;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 11-03-2013 23:38:07
 */
@Entity
public class UserRole extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5020236122880200504L;
	@NotNull
	@Size(min = 2, max = 20)
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
