package org.nicholas.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

import java.security.InvalidParameterException;
import java.util.Set;

public class ValidatorImpl <T> implements Validator <T>{

    @Override
    public boolean validate(T obj) {
        jakarta.validation.Validator validator = createValidator();

        Set<ConstraintViolation<T>> violationSet = validator.validate(obj);

        if (violationSet.isEmpty()) {
            return true;
        } else {
            StringBuilder violations = new StringBuilder();
            violationSet.forEach(v -> violations.append(v.getMessage() + "\n"));
            throw new InvalidParameterException("Object is not valid! \n\tCause:\n" + violations.toString());
        }
    }


    private jakarta.validation.Validator createValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
