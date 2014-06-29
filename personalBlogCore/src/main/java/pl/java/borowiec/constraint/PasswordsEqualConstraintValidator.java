package pl.java.borowiec.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.java.borowiec.annotation.PasswordsEqualConstraint;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 10-04-2013 23:59:35
 */
public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, User> {

	@Override
	public void initialize(PasswordsEqualConstraint constraintAnnotation) {

	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		if (!user.getPassword().equals(user.getConfirmPassword()))
			return false;
		return true;
	}

}
