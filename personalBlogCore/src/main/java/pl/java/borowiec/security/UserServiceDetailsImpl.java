package pl.java.borowiec.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.java.borowiec.dao.user.UserDao;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : igolf-core
 *         Creating time : 02-10-2012 13:13:32
 */

public class UserServiceDetailsImpl implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceDetailsImpl.class);
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = null;

		try {
			user = userDao.findByLogin(username);
		} catch (Exception e) {
			logger.error("Login not exists : {}  , exception {}", username, e);
		}

		/*
		 * if (user == null) {
		 * throw new UsernameNotFoundException("login.not.exists");
		 * } else if (user.getAttemptLoginCount() >= 3) {
		 * throw new UsernameNotFoundException("attempt.3x.login.error");
		 * } else if (user.isAccountLock() || !user.isEnabled()) {
		 * throw new UsernameNotFoundException("user.block");
		 * }
		 */

		return user;
	}

}
