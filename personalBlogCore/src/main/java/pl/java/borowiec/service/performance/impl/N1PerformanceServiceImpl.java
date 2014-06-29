package pl.java.borowiec.service.performance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.performance.CarN1Dao;
import pl.java.borowiec.dao.performance.PersonN1Dao;
import pl.java.borowiec.dao.performance.PersonSpecifications;
import pl.java.borowiec.performance_problem.Car;
import pl.java.borowiec.performance_problem.Person;
import pl.java.borowiec.service.performance.N1PerformanceService;
/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 12:10:28
 */
@Service
@Transactional(readOnly=true)
public class N1PerformanceServiceImpl implements N1PerformanceService {

	private PersonN1Dao personN1Dao;

	private CarN1Dao carN1Dao;

	

	@Autowired
	public N1PerformanceServiceImpl(PersonN1Dao personN1Dao, CarN1Dao carN1Dao) {
		this.personN1Dao = personN1Dao;
		this.carN1Dao = carN1Dao;
		
	}

	@Override
	public List<Person> getAllPerson() {
		return personN1Dao.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		return personN1Dao.findOne(id);
	}

	@Override
	public List<Car> getAllCar() {
		return carN1Dao.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return carN1Dao.findOne(id);
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		carN1Dao.save(car);

	}

	@Override
	@Transactional
	public void savePerson(Person person) {
		personN1Dao.save(person);
	}

	@Override
	public long countPerson() {
		return personN1Dao.count();
	}

	@Override
	public long countCar() {
		return carN1Dao.count();
	}

	@Override
	public Person findByName(String name) {
		return personN1Dao.findByName(name);
	}

	@Override
	public List<Person> lastNameIsLike(String pattern) {
		return personN1Dao.findAll(PersonSpecifications.lastNameIsLike(pattern));
	}

}
