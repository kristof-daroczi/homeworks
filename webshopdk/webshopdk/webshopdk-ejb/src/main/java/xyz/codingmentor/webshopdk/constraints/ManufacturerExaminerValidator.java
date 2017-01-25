package xyz.codingmentor.webshopdk.constraints;

import xyz.codingmentor.webshopdk.entities.DeviceEntity;
import xyz.codingmentor.webshopdk.entities.ManufacturerEnum;
import xyz.codingmentor.webshopdk.entities.MyColorEnum;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Krisz
 */
public class ManufacturerExaminerValidator implements ConstraintValidator<ManufacturerExaminer, DeviceEntity> {

    @Override
    public void initialize(ManufacturerExaminer constraintAnnotation) {
        //empty on purpose
    }

    @Override
    public boolean isValid(DeviceEntity value, ConstraintValidatorContext context) {
        if (value.getManufacturer() == ManufacturerEnum.APPLE) {
            return value.getColor() == MyColorEnum.BLACK || value.getColor() == MyColorEnum.WHITE;
        }

        if (value.getManufacturer() == ManufacturerEnum.SAMSUNG) {
            return value.getColor() != MyColorEnum.GREEN;
        }
        return true;
    }

}
