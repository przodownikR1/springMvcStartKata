package pl.java.borowiec.common.dao.jpa.performance.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.performance.PersonDao;
import pl.java.borowiec.performance_problem.Person;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 09-04-2013 00:26:27
 */
@Repository("personDao")
@Profile("jpa")
public class PersonDaoImpl extends AbstractJpaDao<Person> implements PersonDao {

	public PersonDaoImpl() {
		super(Person.class);
	}

	@Override
	public List<Person> getAll() {
		TypedQuery<Person> query = em.createQuery("FROM Person p", Person.class);
		return query.getResultList();
	}

	@Override
	public void flush() {
		em.flush();

	}

}
