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
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isValid(UserEntity value, ConstraintValidatorContext context) {
        if (value.getFirstname() == null && value.getLastname() == null) {
            return true;
        }
        if (value.getFirstname() != null && value.getLastname() != null) {
            return true;
        }
        return false;
    }
    
}
