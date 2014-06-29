
package pl.java.borowiec.service.exception;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.java.borowiec.exception.UnExpectedException;


@Aspect
//@Service
public class ExceptionLogger {
	private static Logger logger4J = LoggerFactory.getLogger(ExceptionLogger.class);
	@Autowired
	private LoggerExceptionService loggerExceptionService;
	

	@AfterThrowing(pointcut = "AOPPointcutActionDef.serviceExLog()", throwing = "ex")
	public Object logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
		logger4J.error("Unexcpected error {}", ex);
		String logPrefix = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		@SuppressWarnings("unused")
		String[] parameterNames = signature.getParameterNames();
		Object[] parameterValues = joinPoint.getArgs();

		String[] descTab = logPrefix.split("\\.");
		int pos = descTab.length;
		String description;
		if (pos > 2) {
			description = descTab[pos - 2] + "." + descTab[pos - 1];
		} else {
			description = logPrefix;
		}
		String formOrModuleName = joinPoint.getSignature().getDeclaringTypeName();
		String[] formOrModule = formOrModuleName.split("\\.");
		int posForm = formOrModule.length;
		String moduleName;
		if (pos > 2) {
			moduleName = formOrModule[posForm - 2] + "." + formOrModule[posForm - 1];
		} else {
			moduleName = logPrefix;
		}
		String msg = ex.getMessage();
		if (msg == null)
			msg = " ";
		UnExpectedException exp = new UnExpectedException(ex.toString(), msg, description, moduleName, logPrefix, formOrModuleName);
		if (parameterValues.length > 0) {
			exp.setArguments(Arrays.toString(parameterValues));
		}
		loggerExceptionService.persistException(exp);

		return ex;

	}

}
