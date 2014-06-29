package pl.java.borowiec.dao.category;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.category.Category;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  03-04-2013 20:20:48
 
 */
public interface CategoryDao extends JpaRepository<Category, Serializable>{

}
