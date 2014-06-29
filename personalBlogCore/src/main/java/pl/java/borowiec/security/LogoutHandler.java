package pl.java.borowiec.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 09-04-2013 08:24:35
 */
public class LogoutHandler implements LogoutSuccessHandler {
	private static final Logger logger = LoggerFactory.getLogger(LogoutHandler.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		String url = request.getContextPath() + "/loginForm";
		String name = authentication.getName();
		logger.info("logoutSuccess for user : {}", name);
		response.sendRedirect(url);

	}

}