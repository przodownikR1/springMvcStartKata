package pl.java.borowiec.service.user.impl;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.user.UserDao;
import pl.java.borowiec.service.user.UserService;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-03-2013 23:51:06
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
    private UserDao userDao;
	

	
	public UserServiceImpl() {
	}

	@Override
	public User getUserById(Long id){
		return userDao.findOne(id);
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
        userDao.delete(user);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Page<User> getUser(Pageable pageable) {
		return userDao.findAll(pageable);
	}

	@Override
	public UserRole findByRole(String role) {
		throw new NotImplementedException();
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.findByLogin(login);
	}

}
