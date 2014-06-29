package pl.java.borowiec.mail;

import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 12:59:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@Ignore
public class MailSendTest {
	@Autowired
	private MailService mailService;

	@Resource
	private MessageSource messageSource;

	@Test
	public void init() {
		Assert.assertNotNull(mailService);
	}

	@Test
	public void sendMailTest() {
		Locale locale = Locale.getDefault();
		String message[] = new String[] { "borowiec", "slawek" };
		mailService.sendMail(messageSource.getMessage("from", null, locale), "przodownik@tlen.pl", messageSource.getMessage("title", null, locale),
				messageSource.getMessage("message_activation", message, locale));
	}

}
