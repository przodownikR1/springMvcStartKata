package pl.java.borowiec.common.dao.jpa.criteria.user;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractCriteriaJpaDao;
import pl.java.borowiec.common.dao.jpa.UserDao;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  06-04-2013 21:01:00
 
 */
@Repository("userCriteriaDao")
@Profile("jpa")
public class UserCriteriaDaoImpl extends AbstractCriteriaJpaDao<User> implements UserDao{

	public UserCriteriaDaoImpl() {
		super(User.class);

	}
	

	public UserCriteriaDaoImpl(Class<User> clazzToSet) {
		super(clazzToSet);
		// TODO Auto-generated constructor stub
	}
	@Override
	public User findByLogin(String login) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> c = cb.createQuery(User.class);
		Root<User> root = c.from(User.class);
		c.select(root).where(cb.equal(root.get("login"), login));
		TypedQuery<User> q = em.createQuery(c);
		return q.getSingleResult();
		
	}

	@Override
	public List<User> findByLastName(String lastName) {
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> c = cb.createQuery(User.class);
		Root<User> root = c.from(User.class);
		c.select(root).where(cb.like(root.get("lastName"),lastName+"%"));
		TypedQuery<User> q = em.createQuery(c);
		return q.getResultList();*/
		return null;
	}

	@Override
	public List<User> getUserByRole(UserRole userRole) {
	/*	CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> c = cb.createQuery(User.class);
		Root<User> root = c.from(User.class);
		root.join(pl.java.borowiec.user.User_.roles);
		c.select(root).where(cb.equal(pl.java.borowiec.user.UserRole_, userRole));
		TypedQuery<User> q = em.createQuery(c);*/
		//return q.getResultList();
		return null;
	}

	

}
