package pl.java.borowiec.dao.performance;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pl.java.borowiec.performance_problem.Person;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  14-04-2013 12:08:15
 
 */
public interface PersonN1Dao extends JpaRepository<Person, Serializable> ,JpaSpecificationExecutor<Person>{
	
	Person findByName(String name);
}
