package pl.java.borowiec.common.dao.jpa.user.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.UserDao;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 15:14:53
 */
@Repository("userDao")
@Profile("jpa")
public class UserDaoImpl extends AbstractJpaDao<User> implements UserDao {

	
	
	public UserDaoImpl() {
		super(User.class);

	}
	

	public UserDaoImpl(Class<User> clazzToSet) {
		super(clazzToSet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public User findByLogin(String login) {
		return em.createQuery("From User u Where u.login = :login", User.class).setParameter("login", login).getSingleResult();
	}

	@Override
	public List<User> findByLastName(String lastName) {
		return em.createQuery("From User u Where u.lastName like :lastName", User.class).setParameter("lastName", lastName + "%").getResultList();

	}

	@Override
	public List<User> getUserByRole(UserRole userRole) {
		List<User> result = em.createQuery("SELECT user FROM USER user JOIN user.roles role where role = :role",User.class).setParameter("role", userRole).getResultList();
		return result;
	}

}
