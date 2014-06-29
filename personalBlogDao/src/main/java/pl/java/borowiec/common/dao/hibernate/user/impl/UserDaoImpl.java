package pl.java.borowiec.common.dao.hibernate.user.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.hibernate.AbstractHibernateDao;
import pl.java.borowiec.common.dao.hibernate.UserDao;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  06-04-2013 15:14:53
 
 */
@Repository("userDao")
@Profile("hibernate")
public class UserDaoImpl  extends AbstractHibernateDao<User> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User findByLogin(String login) {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByLastName(String lastName) {
        Query query  = getCurrentSession().createQuery("From User u WHERE u.lastName like :lastName").setParameter("lastName", lastName+"%");
		return query.list();
	}

	@Override
	public List<User> getUserByRole(UserRole userRole) {
		Query query  = getCurrentSession().createQuery("SELECT u From User u join u.roles role  WHERE role = :userRole").setParameter("userRole", userRole);
		return query.list();
	}

	


	
	
	

}
