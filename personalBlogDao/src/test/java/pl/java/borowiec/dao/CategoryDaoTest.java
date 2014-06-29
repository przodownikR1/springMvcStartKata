package pl.java.borowiec.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.java.borowiec.category.Category;
import pl.java.borowiec.dao.category.CategoryDao;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 03-04-2013 21:12:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:dao.xml" })
@ActiveProfiles("spring-data-test")
@Transactional
public class CategoryDaoTest extends InitExampleObject {
	@Autowired
	private CategoryDao categoryDao;

	@Test
	public void persistTest() {
		categoryDao.save(programming);
		categoryDao.flush();
		assertEquals(1, categoryDao.count());
		Category parent = categoryDao.findAll().get(0);

		for (Category sub : parent.getSubCategories()) {

		}

	}

}
