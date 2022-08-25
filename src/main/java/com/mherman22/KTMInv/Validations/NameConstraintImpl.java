package com.mherman22.KTMInv.Validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameConstraintImpl implements ConstraintValidator<NameConstraint, String> {

    /**
     * The method takes in your constraint object
     * 
     * @param name
     */
    @Override
    public void initialize(NameConstraint name) {

    }

    /**
     * the regex expression checks the string for any numbers.
     * If it finds one it returns true, but we need it to
     * return false to fail the validation. So add a ‘!’ on front of the expression.
     * 
     * @param value
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.matches(".*\\d.*");
    }

}
