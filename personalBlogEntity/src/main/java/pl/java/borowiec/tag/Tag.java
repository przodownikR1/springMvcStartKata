package pl.java.borowiec.tag;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.common.CommonEntity;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 29-03-2013 23:59:19
 */
@Entity
public class Tag extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3175405194252034474L;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String name;

	public Tag() {
		super();
	}

	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
