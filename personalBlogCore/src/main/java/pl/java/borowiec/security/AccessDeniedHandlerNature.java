package pl.java.borowiec.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 09-04-2013 08:23:51
 */
public class AccessDeniedHandlerNature implements AccessDeniedHandler {
	private static final Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerNature.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		logger.info("handle access denied  path {} , message {}: ", request.getPathInfo(), accessDeniedException.getMessage());
		String path = request.getRequestURI();
		request.setAttribute("errorDetails", accessDeniedException.getMessage());
		request.setAttribute("path", path);
		request.setAttribute("user", request.getUserPrincipal().getName());
		response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());

	}

}
