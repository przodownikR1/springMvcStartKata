/**
 * 
 */
package pl.java.borowiec.dao.tag;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:46:09
 
 */
public interface TagDao extends JpaRepository<Tag, Serializable>{

}
