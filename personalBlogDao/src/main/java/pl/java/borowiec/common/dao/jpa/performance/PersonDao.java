package pl.java.borowiec.common.dao.jpa.performance;

import pl.java.borowiec.performance_problem.Person;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  09-04-2013 00:37:16
 
 */
public interface PersonDao extends GenericDao<Person>{
	
	void flush();
	
}