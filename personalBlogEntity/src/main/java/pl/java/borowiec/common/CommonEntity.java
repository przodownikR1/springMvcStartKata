package pl.java.borowiec.common;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 10-03-2013 23:26:28
 */
@MappedSuperclass
public abstract class CommonEntity extends PKEntity {

	private static final long serialVersionUID = -7901407735478652066L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modyfication")
	@Basic(fetch = FetchType.LAZY)
	protected Date dateModyfication;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_added", nullable = false)
	@Basic(fetch = FetchType.LAZY)
	protected Date dateAdded = new Date(); // profile hibernate problem can't see @PrePersist //JPA callbacks won't work if you're using the Session API.

	public Date getDateModyfication() {
		return dateModyfication;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static boolean emptyString(String input) {
		return input == null || input.equals("");
	}

	@PrePersist
	private void initPrePersist() {
		dateAdded = new Date();
	}

	@PreUpdate
	private void initPreUpdate() {
		dateModyfication = new Date();
		if (dateAdded == null) {
			dateAdded = dateModyfication;
		}
	}

	// jdbc fetch problem
	public void setDateModyfication(Date dateModyfication) {
		this.dateModyfication = dateModyfication;
	}

	// jdbc fetch problem
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

}
