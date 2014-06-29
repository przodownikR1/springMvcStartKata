package pl.java.borowiec.performance_problem;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;

import pl.java.borowiec.common.CommonEntity;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 09-04-2013 00:17:25
 */
@Entity
public class Person extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -380359512663263346L;
	private String name;
	private String address;
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private List<Car> cars = new ArrayList<Car>();

	public Person() {
		super();
	}

	public Person(String name, String address, List<Car> cars) {
		super();
		this.name = name;
		this.address = address;
		this.cars = cars;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
