package xyz.codingmentor.firsteehomework.constraints;

import xyz.codingmentor.firsteehomework.entities.UserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Krisz
 */
public class BirthdateExaminerValidator implements ConstraintValidator<BirthdateExaminer, UserEntity> {

    @Override
    public void initialize(BirthdateExaminer constraintAnnotation) {
        //empty on purpose 
    }

    @Override
    public boolean isValid(UserEntity value, ConstraintValidatorContext context) {
        if (value.getDateOfBirth() != null) {
            return value.getDateOfBirth().before(value.getRegistrationDate());
        }
        return true;
    }

}
