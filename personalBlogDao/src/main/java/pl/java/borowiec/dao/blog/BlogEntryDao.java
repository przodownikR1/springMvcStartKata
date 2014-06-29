package pl.java.borowiec.dao.blog;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.blog.BlogEntry;



/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:43:39
 
 */
public interface BlogEntryDao extends JpaRepository<BlogEntry, Serializable> { 
}
