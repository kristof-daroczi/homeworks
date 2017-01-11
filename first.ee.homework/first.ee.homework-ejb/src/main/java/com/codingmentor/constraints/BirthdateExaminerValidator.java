
package com.codingmentor.constraints;

import com.codingmentor.entities.UserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Krisz
 */
public class BirthdateExaminerValidator implements ConstraintValidator<BirthdateExaminer, UserEntity> {

    @Override
    public void initialize(BirthdateExaminer constraintAnnotation) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(UserEntity value, ConstraintValidatorContext context) {
        if (value.getDateOfBirth() != null) {
            return value.getDateOfBirth().before(value.getRegistrationDate());
        }
        return false;
    }

}
