package pl.java.borowiec.dictionary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Min;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 10-04-2013 23:50:01
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Dictionary  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 946482179456211283L;

	
	@SuppressWarnings("hiding")
	@Id
	@Min(0L)
	@GeneratedValue(generator="id-generator", strategy=GenerationType.TABLE)
	@TableGenerator(name="id-generator",initialValue=1)
	@Column(name = "ID", nullable = false, precision = 38, scale = 0)
	protected Long id;
	
	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
