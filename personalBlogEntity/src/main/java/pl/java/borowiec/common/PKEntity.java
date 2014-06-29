package pl.java.borowiec.common;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 10-03-2013 23:24:59
 */
@MappedSuperclass
public abstract class PKEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7669211182758111346L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}