

package pl.java.borowiec.exception;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import pl.java.borowiec.common.CommonEntity;




@MappedSuperclass
public class ExceptionHandling extends CommonEntity{
	private static final long serialVersionUID = -3520510599039979657L;


	@NotNull
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "EXCEPTION", nullable = false)
	private String exception;

	@Lob
	@Column(name = "MESSAGE")
	@Basic(fetch=FetchType.LAZY)
	private String message;
	public static final String MESSAGE_FIELD_NAME = "message";

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "DESCRIPTION")
	private String description;

	public ExceptionHandling() {
		super();
	}

	public ExceptionHandling(String exception, String message, String description) {
		super();
		this.dateAdded = new Date();
		this.exception = exception;
		this.message = message;
		this.description = description;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
