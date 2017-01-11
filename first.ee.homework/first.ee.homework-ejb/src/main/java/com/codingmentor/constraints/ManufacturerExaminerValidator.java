
package com.codingmentor.constraints;

import com.codingmentor.entities.DeviceEntity;
import com.codingmentor.entities.ManufacturerEnum;
import com.codingmentor.entities.MyColorEnum;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Krisz
 */
public class ManufacturerExaminerValidator implements ConstraintValidator<ManufacturerExaminer, DeviceEntity> {

    @Override
    public void initialize(ManufacturerExaminer constraintAnnotation) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(DeviceEntity value, ConstraintValidatorContext context) {
        if (value.getManufacturer() == ManufacturerEnum.APPLE) {
            return value.getColor() == MyColorEnum.BLACK || value.getColor()==MyColorEnum.WHITE;
        }

        if (value.getManufacturer() == ManufacturerEnum.SAMSUNG) {
            return value.getColor() != MyColorEnum.GREEN;
        }
        
        return true;
    }

}
