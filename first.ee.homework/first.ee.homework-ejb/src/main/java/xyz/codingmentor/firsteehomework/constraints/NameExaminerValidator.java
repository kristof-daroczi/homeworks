package xyz.codingmentor.firsteehomework.constraints;

import xyz.codingmentor.firsteehomework.entities.UserEntity;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Krisz
 */
public class NameExaminerValidator implements ConstraintValidator<NameExaminer, UserEntity> {

    @Override
    public void initialize(NameExaminer constraintAnnotation) {
        // empty on purpose
    }

    @Override
    public boolean isValid(UserEntity value, ConstraintValidatorContext context) {
        boolean isEmpty = (value.getFirstname() == null) && (value.getLastname() == null);
        boolean isNotEmpty = (value.getFirstname() != null) && (value.getLastname() != null);

        return isEmpty || isNotEmpty;
    }

}
