package pl.java.borowiec.jpa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.java.borowiec.common.dao.jpa.TagDao;
import pl.java.borowiec.dao.InitExampleObject;


/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 30-03-2013 11:09:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@Transactional
@ActiveProfiles("jpa")
public class TagDaoTest extends InitExampleObject {
	@Autowired
	private TagDao tagDao;

	public TagDaoTest() {

	}

	@Test
	public void initTest() {
		Assert.assertNotNull(tagDao);
	}

	@Test
	public void persistTest() {
		tagDao.save(tag1);
		Assert.assertEquals(1, tagDao.countAll());
		tagDao.save(tag2);
		Assert.assertEquals(2, tagDao.countAll());

	}

}
