package pl.java.borowiec.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 11-04-2013 00:11:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Service
@Transactional(readOnly = true)
public @interface AppService {
	String value() default "";

}
