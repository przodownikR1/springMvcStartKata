package pl.java.borowiec.common.dao.hibernate.hbc.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.hibernate.AbstractHibernateDao;
import pl.java.borowiec.common.dao.hibernate.UserDao;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;
@Repository("userCriteriaDao")
@Profile("hibernate")
public class UserCriteriaDao extends AbstractHibernateDao<User> implements UserDao{

	public UserCriteriaDao() {
		super(User.class);
	}

	@Override
	public User findByLogin(String login) {
        Criteria crit =  getCurrentSession().createCriteria(User.class).add(Expression.eq("login", login));
        return (User) crit.uniqueResult();
		
	}

	@Override
	public List<User> findByLastName(String lastName) {
		Criteria crit = getCurrentSession().createCriteria(User.class).add(Expression.like("lastName", lastName, MatchMode.END));
		return crit.list();
	}

	@Override
	public List<User> getUserByRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}



}
