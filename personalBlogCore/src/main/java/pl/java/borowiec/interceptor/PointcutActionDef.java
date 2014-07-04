package pl.java.borowiec.interceptor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-03-2013 23:43:12
 */
@Aspect
public class PointcutActionDef {
	@Pointcut("execution(public * pl.java.borowiec.service..*.*(..))")
	public void serviceLog() {
	}
	
	

}
