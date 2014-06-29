package pl.java.borowiec.tools;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 12:40:09
 */
public final class ControllerTools {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerTools.class);

	private ControllerTools() {
		throw new AssertionError();
	}

	public static boolean isCompressionSupported(HttpServletRequest httpRequest) {
		boolean supportCompression = false;
		@SuppressWarnings("unchecked")
		final List<String> acceptEncodings = Collections.list(httpRequest.getHeaders("Accept-Encoding"));
		for (final String name : acceptEncodings) {
			if (name.contains("gzip")) {
				supportCompression = true;
				break;
			}
		}
		return supportCompression;
	}

	public static void noCache(HttpServletResponse httpResponse) {
		httpResponse.addHeader("Cache-Control", "no-cache");
		httpResponse.addHeader("Pragma", "no-cache");
		httpResponse.addHeader("Expires", "-1");
	}

	public static void printSessionAttr(HttpSession session) {
		LOGGER.info("--------------------------------------HTTP SESSION INSPECT--------------------------");
		Enumeration<?> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String attribName = (String) en.nextElement();
			Object attribValue = session.getAttribute(attribName);
			LOGGER.info("attribute : " + attribName + " attribValue " + attribValue);
		}
		LOGGER.info("--------------------------------------HTTP SESSION INSPECT END--------------------------");
	}

}
