
package pl.java.borowiec.service.exception;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  11-04-2013 00:07:34
 
 */
@Aspect
public class AOPPointcutActionDef {
	
	@Pointcut("@annotation(pl.java.borowiec.annotation.CatchException)) ")
	public void serviceExLog(){

	}
	
}
