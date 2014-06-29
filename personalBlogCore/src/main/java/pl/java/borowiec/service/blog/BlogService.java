package pl.java.borowiec.service.blog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pl.java.borowiec.blog.Blog;
import pl.java.borowiec.blog.BlogEntry;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  30-03-2013 14:45:06
 
 */
public interface BlogService {

	Blog createBlog(Blog blog);
	BlogEntry createBlogEntry(Blog blog,BlogEntry blogEntry);
	void removeBlogEntry(User user ,BlogEntry blogEntry);
	List<Blog> getAllBlog();
	List<BlogEntry> getAllBlogEntry();
	Page<Blog> fingBlog(Pageable pageable);
	Page<BlogEntry> fingBlogEntry(Pageable pageable);
	Page<Blog> findBlogByUser(User user, Pageable pageable);
	Page<BlogEntry> findBlogEntryByUser(User user,Pageable pageable);
	
}
