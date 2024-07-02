package com.example.demo.validators;

import com.example.demo.exceptions.ObjectNotValidException;
import jakarta.validation.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public <T> void validate(T objectsToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(objectsToValidate);
        if(!violations.isEmpty()){
         var errorMessages =   violations.stream().
            map(ConstraintViolation::getMessage).
            collect(Collectors.toSet());

         throw new ObjectNotValidException(errorMessages);

        }
    }
}
