package pl.java.borowiec.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.java.borowiec.simple.Invoice;
@Component
public class InvoiceValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return (Invoice.class).isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Invoice invoice = (Invoice)obj;
        ValidationUtils.rejectIfEmpty(errors, "name","name.required" );
        if(!startsWithUpper(invoice.getName())){
            errors.rejectValue("name", "name.shouldStartWithCapitalLetter");
        }
        
    }
    boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
      }
}
