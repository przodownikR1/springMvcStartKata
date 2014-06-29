package pl.java.borowiec.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import pl.java.borowiec.constraint.PasswordsEqualConstraintValidator;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 23:58:16
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Size(min = 6)
@NotEmpty(message = "notEmpty")
@Constraint(validatedBy = PasswordsEqualConstraintValidator.class)
public @interface PasswordsEqualConstraint {
	String message();

	String field();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
