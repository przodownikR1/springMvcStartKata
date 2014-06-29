package pl.java.borowiec.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-03-2013 23:41:51
 */
public class TraceLoggerInterceptor extends CustomizableTraceInterceptor {

	private static final long serialVersionUID = 287162721460370957L;
	private final static Logger logger = LoggerFactory.getLogger(ServicePerformanceLogger.class);

	@Override
	protected void writeToLog(Log logger, String message, Throwable ex) {
		if (ex != null) {
			logger.warn(message, ex);
		} else {
			logger.warn(message);
		}
	}

	@Override
	protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
		return true;
	}

}
