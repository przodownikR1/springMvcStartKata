package pl.java.borowiec.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.borowiec.simple.code.Book;
import pl.java.borowiec.simple.code.Cd;
import pl.java.borowiec.simple.code.Product;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 15:48:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class BeanTest {
	static final Logger LOGGER = LoggerFactory.getLogger(BeanTest.class);
	@Autowired
	@Qualifier("springBook")
	private Book book;

	@Autowired
	private Cd cd;
	@Autowired
	private Cd metallicaCd;
	@Autowired
	@Qualifier("book2")
	private Book book2;

	@Autowired
	private Book[] products;

	@Autowired
	private Product cdStaticFactory;

	@Autowired
	private Product abcBook;

	@Test
	public void checkBean() {
		LOGGER.info("book : {} ", book);
		LOGGER.info("metallica cd {}", metallicaCd);
		LOGGER.info("other cd : {} ", cd);
		LOGGER.info("factory book2 : {} ", book2);
		for (Product p : products) {
			LOGGER.info("products autowired :  {}", p);

		}

		LOGGER.info("cd created by factory : {}", cdStaticFactory);
		LOGGER.info("static :  {}", abcBook);
	}

}
