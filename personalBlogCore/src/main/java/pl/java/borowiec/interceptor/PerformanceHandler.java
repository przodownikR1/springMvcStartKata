package pl.java.borowiec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pl.java.borowiec.jmx.PerformanceMonitor;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 14-04-2013 00:11:56
 */
public class PerformanceHandler implements HandlerInterceptor {

	private final static Logger logger = LoggerFactory.getLogger(PerformanceHandler.class);

	private static final String START_TIME = "PERF_START";
	@Autowired
	private PerformanceMonitor performanceMonitor;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute(START_TIME, new Long(System.currentTimeMillis()));
		return true;
	}

	/*
	 * Measure execution request time and write to log
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (request.getRequestURI().endsWith(".js") || request.getRequestURI().endsWith(".css") || request.getRequestURI().endsWith(".pgn")
				|| request.getRequestURI().endsWith(".jpg"))
			return;
		Long startTime = (Long) request.getAttribute(START_TIME);
		request.removeAttribute("startTime");
		if (startTime != null) {
			String uri = request.getRequestURI();
			String query = request.getQueryString();
			long last = System.currentTimeMillis() - startTime.longValue();
			String cut = request.getContextPath() + "" + request.getServletPath();
			uri.replace(cut, "");
			performanceMonitor.setMethodResponseTime(uri, last);
			// DumpStack.dumpStacks();
			// performanceMonitor.increaseViewCount(last);

			if (query != null) {
				uri = uri + '?' + query;
				logger.info("URL: " + uri);
			}
			logger.info("Execute after rendering: " + last + "ms.");

		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		Long startTime = (Long) request.getAttribute(START_TIME);
		long last = System.currentTimeMillis() - startTime.longValue();
		if (modelAndView != null) {
			modelAndView.addObject("handlingTime", last);
			System.err.println("from  modelAndView handling");
		} else {

			request.setAttribute("handlingTIme", last);
		}

	}
}
