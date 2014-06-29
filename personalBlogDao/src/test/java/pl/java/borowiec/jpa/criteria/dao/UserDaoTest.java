package pl.java.borowiec.jpa.criteria.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.common.dao.jpa.UserDao;
import pl.java.borowiec.dao.InitExampleObject;


/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@Transactional
@ActiveProfiles("jpa")
public class UserDaoTest extends InitExampleObject {

	public UserDaoTest() {

	}

	@Autowired
	private UserDao userCriteriaDao;

	@Test
	public void initTest() {
		Assert.assertNotNull(userCriteriaDao);
	}

	@Test
	public void persistTest() {
		userCriteriaDao.save(userSlawek);
		Assert.assertEquals(1, userCriteriaDao.countAll());
		userCriteriaDao.save(userTomek);
		Assert.assertEquals(2, userCriteriaDao.countAll());
	}

}
