

package pl.java.borowiec.exception;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.common.PKEntity;



@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class ExceptionHandling extends PKEntity{
	private static final long serialVersionUID = -3520510599039979657L;


	@NotNull
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "exception", nullable = false)
	private String exception;

	@Lob
	@Column(name = "exception_message")
	@Basic(fetch=FetchType.LAZY)
	private String message;


	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name = "exception_description")
	private String description;



}
