package pl.java.borowiec.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.comment.CommentDao;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles("spring-data-test")
@Transactional
public class CommentDaoTest {
	@Autowired
	private CommentDao commentDao;

	@Test
	public void initTest() {
		Assert.assertNotNull(commentDao);
	}
}
