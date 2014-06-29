package pl.java.borowiec.jdbc.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 13:41:10
 */
public interface UserJdbcRepository {
	User findById(long id) throws DataAccessException;

	void save(User user) throws DataAccessException;

	List<User> getAllUser() throws DataAccessException;

	User findByLogin(String login) throws DataAccessException;

	List<User> findByLastName(String lastName) throws DataAccessException;

	int remove(User user);

	int countAll();
}