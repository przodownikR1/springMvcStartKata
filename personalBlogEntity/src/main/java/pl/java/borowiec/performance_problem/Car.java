package pl.java.borowiec.performance_problem;

import javax.persistence.Entity;

import pl.java.borowiec.common.CommonEntity;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 09-04-2013 00:17:20
 */
@Entity
public class Car extends CommonEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505386057844313491L;

	public Car() {
		super();
	}

	public Car(String make, int age) {
		super();
		this.make = make;
		this.age = age;
	}

	private String make;
	private int age;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", age=" + age + "]";
	}

}
