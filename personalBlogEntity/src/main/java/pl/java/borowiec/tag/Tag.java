package pl.java.borowiec.tag;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.common.PKEntity;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Tag extends PKEntity{

	private static final long serialVersionUID = -3175405194252034474L;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String name;



}
