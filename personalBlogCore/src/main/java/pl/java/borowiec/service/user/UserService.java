package pl.java.borowiec.service.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  11-03-2013 23:51:11
 
 */
public interface UserService {
	String ROLE_USER = "ROLE_USER";
	String ROLE_ADMIN = "ROLE_ADMIN";
	String ROLE_GUEST = "ROLE_GUEST";
	
	User getUserById(Long id);
	List<User> getUsers();
	void deleteUser(User user);
	User saveUser(User user);
	Page<User> getUser(Pageable pageable);
	UserRole findByRole(String role);
	User getUserByLogin(String login);
	
	
	
}
