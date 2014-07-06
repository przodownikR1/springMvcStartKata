package pl.java.borowiec.performance_problem;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.java.borowiec.common.AbstactId;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 09-04-2013 00:17:20
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Car extends AbstactId{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505386057844313491L;


	private String make;
	private int age;


}
