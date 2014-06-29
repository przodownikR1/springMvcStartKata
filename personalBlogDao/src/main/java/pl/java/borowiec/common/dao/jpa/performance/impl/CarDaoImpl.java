package pl.java.borowiec.common.dao.jpa.performance.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.performance.CarDao;
import pl.java.borowiec.performance_problem.Car;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  09-04-2013 00:25:08
 
 */
@Repository("carDao")
@Profile("jpa")
public class CarDaoImpl extends AbstractJpaDao<Car> implements CarDao{

	public CarDaoImpl() {
		super(Car.class);
	}

}
