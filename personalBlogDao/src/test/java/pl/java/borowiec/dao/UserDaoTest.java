package pl.java.borowiec.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.dao.user.UserDao;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@Transactional
@ActiveProfiles("spring-data-test")
public class UserDaoTest extends InitExampleObject {

	public UserDaoTest() {

	}

	@Autowired
	private UserDao userDao;

	@Test
	public void initTest() {
		Assert.assertNotNull(userDao);
	}

	@Test
	public void persistTest() {
		userDao.save(userSlawek);
		Assert.assertEquals(1, userDao.count());
		userDao.save(userTomek);
		Assert.assertEquals(2, userDao.count());
	}

}
