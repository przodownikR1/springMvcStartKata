package pl.java.borowiec.dao.comment;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.borowiec.comment.Comment;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  30-03-2013 10:45:21
 
 */
public interface CommentDao extends JpaRepository<Comment, Serializable>{

}
