package pl.java.borowiec.common.dao.jpa;

import java.util.List;

import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 15:14:48
 */
public interface UserDao {
	User findById(Long id);

	void save(User user);

	User update(User user);

	List<User> getAll();

	User findByLogin(String login);

	List<User> findByLastName(String lastName);

	void remove(User user);

	long countAll();

	List<User> getUserByRole(UserRole userRole);
}
