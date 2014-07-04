
package pl.java.borowiec.exception;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogEntity
 * Creating time :  11-04-2013 00:01:17
 
 */
@Entity
@XmlRootElement
@Data
public class UnExpectedException extends ExceptionHandling {
	private static final long serialVersionUID = 8284569238600218725L;
	protected static final String TABLE_NAME = "UNEXPECTED_EXCEPTION";


	@NotNull
	@Column(name = "ERROR_NUMBER", nullable = false, length = 128)
	private String errorNumber;


	@NotNull
	@Column(name = "FUNCTION_NAME", nullable = false, length = 128)
	private String functionName;
	public static final String FUNCTION_NAME_FIELD_NAME = "functionName";


	@NotNull
	@Column(name = "FORM_OR_MODULE_NAME", nullable = false, length = 128)
	private String formOrModuleName;
	public static final String FORM_OR_MODULE_NAME_FIELD_NAME = "formOrModuleName";


	@Column(name = "ARGUMENTS", length = 256)
	private String arguments;
	public static final String ARGUMENTS_FIELD_NAME = "arguments";

	public UnExpectedException(String exception, String message, String description, String errorNumber, String functionName,
			String formOrModuleName) {
		super(exception, message, description);
		this.errorNumber = errorNumber;
		this.functionName = functionName;
		this.formOrModuleName = formOrModuleName;
	}

	public UnExpectedException() {
		super();
	}

	public UnExpectedException(String exception, String message, String description) {
		super(exception, message, description);
	}

	
}
