package pl.java.borowiec.dao.blog;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.blog.Blog;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:43:06
 
 */
public interface BlogDao extends JpaRepository<Blog, Serializable>{

}
