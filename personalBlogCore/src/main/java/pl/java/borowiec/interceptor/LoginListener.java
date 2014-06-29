package pl.java.borowiec.interceptor;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.SessionCreationEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 00:08:19
 */
@Component
public class LoginListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		if (event instanceof SessionDestroyedEvent) {
			System.err.println("Session destroyed");
		}
		if (event instanceof SessionCreationEvent) {
			System.err.println("SessionCreateEvent");
		}

	}

}