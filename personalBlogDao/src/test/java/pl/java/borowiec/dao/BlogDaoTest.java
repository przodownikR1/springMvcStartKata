package pl.java.borowiec.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.blog.BlogDao;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles("spring-data-test")
@Transactional
public class BlogDaoTest {
	@Autowired
	private BlogDao blogDao;

	public BlogDaoTest() {

	}

	@Test
	public void initTest() {
		Assert.assertNotNull(blogDao);
	}
}
