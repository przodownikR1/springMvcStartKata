package pl.java.borowiec.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-03-2013 23:43:02
 */
@Aspect
// @Component("loggerAOP")
public class ServicePerformanceLogger {
	private final static Logger logger = LoggerFactory.getLogger(ServicePerformanceLogger.class);

	@Around("PointcutActionDef.serviceLog()")
	public Object O(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(pjp.getSignature().getName());
		Object returnValue = pjp.proceed();
		sw.stop();
		logger.info(" method : " + pjp.getSignature().getName() + "  time:  " + sw.prettyPrint());
		return returnValue;
	}

}