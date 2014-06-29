package pl.java.borowiec.service.performance;

import java.util.List;

import pl.java.borowiec.performance_problem.Car;
import pl.java.borowiec.performance_problem.Person;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  14-04-2013 12:11:08
 
 */
public interface N1PerformanceService {

	
	List<Person> getAllPerson();
	Person getPersonById(Long id);
	List<Car> getAllCar();
	Car getCarById(Long id);
	void saveCar(Car car);
	void savePerson(Person person);
	long countPerson();
	long countCar();
	Person findByName(String name);
	List<Person> lastNameIsLike(String pattern);//join fetch
}
