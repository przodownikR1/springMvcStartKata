package pl.java.borowiec.dao.performance;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.performance_problem.Car;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  14-04-2013 12:08:01
 
 */
public interface CarN1Dao extends JpaRepository<Car, Serializable>{

}
