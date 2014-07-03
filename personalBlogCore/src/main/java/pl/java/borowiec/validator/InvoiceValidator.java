package pl.java.borowiec.validator;

import java.util.regex.Pattern;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pl.java.borowiec.simple.Invoice;


@Component
public class InvoiceValidator implements Validator{  //wymagana dla validatora

    @Override
    public boolean supports(Class<?> clazz) {
        return (Invoice.class).isAssignableFrom(clazz); //klasa ktora chcemy validowac
    }

    @Override
    public void validate(Object obj, Errors errors) {  //kubel na wszelkie bledy z formularza
        Invoice invoice = (Invoice)obj;
        
        ValidationUtils.rejectIfEmpty(errors, "name","name.required"); //rejestruj blad 
        
        if(!startsWithUpper(invoice.getName())){
            errors.rejectValue("name", "name.shouldStartWithCapitalLetter"); //jesli ciag zaczyna sie z duzej litery wtedy 
            //dodaj do puli bledow
        }
         
    }
    boolean startsWithUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
      }
}
