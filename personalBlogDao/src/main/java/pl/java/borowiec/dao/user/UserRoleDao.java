package pl.java.borowiec.dao.user;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.user.UserRole;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:42:30
 
 */
public interface UserRoleDao extends JpaRepository<UserRole, Serializable>{

}
