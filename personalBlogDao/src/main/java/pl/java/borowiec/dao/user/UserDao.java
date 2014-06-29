package pl.java.borowiec.dao.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:41:33
 
 */
public interface UserDao extends JpaRepository<User, Serializable> {

	User findByLogin(String username);

}
