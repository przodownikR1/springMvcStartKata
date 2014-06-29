package pl.java.borowiec.service.blog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.blog.Blog;
import pl.java.borowiec.blog.BlogEntry;
import pl.java.borowiec.dao.blog.BlogDao;
import pl.java.borowiec.dao.blog.BlogEntryDao;
import pl.java.borowiec.service.blog.BlogService;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 30-03-2013 14:40:04
 */
@Service
@Transactional(readOnly = true)
public class BlogServiceImpl implements BlogService {
	static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);
	@Autowired
	private BlogDao blogDao;
	
	List<Blog> blogs = new ArrayList<Blog>();

	public BlogServiceImpl(){
		Blog b = new Blog();
		b.setName("slawek");
		b.setDateAdded(new Date());
		b.setDateModyfication(new Date());
		b.setId(1l);
		
		blogs.add(b);
		b = new Blog();
		b.setName("pawel");
		b.setDateAdded(new Date());
		b.setDateModyfication(new Date());
		b.setId(2l);
		blogs.add(b);
	}
	
	@Autowired
	private BlogEntryDao blogEntryDao;

	@Override
	public Blog createBlog(Blog blog) {
		blogs.add(blog);
		return blog;
	}

	@Override
	public BlogEntry createBlogEntry(Blog blog, BlogEntry blogEntry) {
		throw new NotImplementedException();
		
	}

	@Override
	public void removeBlogEntry(User user, BlogEntry blogEntry) {
		throw new NotImplementedException();

	}

	@Override
	public List<Blog> getAllBlog() {
		return blogs;
	}

	@Override
	public List<BlogEntry> getAllBlogEntry() {
		throw new NotImplementedException();
	}

	@Override
	public Page<Blog> fingBlog(Pageable pageable) {
		Pageable pageRequest = new PageRequest(0, 5);
		
		return null;
	}

	@Override
	public Page<BlogEntry> fingBlogEntry(Pageable pageable) {
		throw new NotImplementedException();
	}

	@Override
	public Page<Blog> findBlogByUser(User user, Pageable pageable) {
		throw new NotImplementedException();
	}

	@Override
	public Page<BlogEntry> findBlogEntryByUser(User user, Pageable pageable) {
		throw new NotImplementedException();
	}

}
