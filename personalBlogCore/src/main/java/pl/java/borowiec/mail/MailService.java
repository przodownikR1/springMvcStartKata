package pl.java.borowiec.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 12:51:15
 */
@Component
public class MailService {
	@Autowired(required = false)
	private MailSender mailSender;
	@Autowired(required = false)
	private SimpleMailMessage alertMailMessage;

	public void sendMail(String from, String to, String subject, String body) throws MailSendException {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);

	}

	public void sendAlertMail(String alert) {

		SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
		mailMessage.setText(alert);
		mailSender.send(mailMessage);

	}

}
