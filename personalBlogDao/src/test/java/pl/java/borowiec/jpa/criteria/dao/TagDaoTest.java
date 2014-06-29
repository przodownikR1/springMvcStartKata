package pl.java.borowiec.jpa.criteria.dao;

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
	private TagDao tagCriteriaDao ;

	public TagDaoTest() {

	}

	@Test
	public void initTest() {
		Assert.assertNotNull(tagCriteriaDao);
	}

	@Test
	public void persistTest() {
		tagCriteriaDao.save(tag1);
		Assert.assertEquals(1, tagCriteriaDao.countAll());
		tagCriteriaDao.save(tag2);
		Assert.assertEquals(2, tagCriteriaDao.countAll());

	}

}
