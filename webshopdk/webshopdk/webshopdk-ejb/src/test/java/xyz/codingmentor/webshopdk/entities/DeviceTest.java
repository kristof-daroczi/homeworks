
package xyz.codingmentor.webshopdk.entities;

import xyz.codingmentor.webshopdk.entities.ManufacturerEnum;
import xyz.codingmentor.webshopdk.entities.DeviceEntity;
import xyz.codingmentor.webshopdk.entities.MyColorEnum;
import java.util.Set;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krisz
 */
public class DeviceTest {

    public DeviceTest() {
    }

    private static ValidatorFactory vf;
    private static javax.validation.Validator validator;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void tearDownClass() {
        vf.close();
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfUuid() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "id");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfNotCorrectUuid() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setId("randomstring");
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "id");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfUuidIsNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(null);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "id");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfUuidIsNull() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "id");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfManufacturerIsNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setManufacturer(ManufacturerEnum.APPLE);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "manufacturer");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfManufacturerIsNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setManufacturer(null);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "manufacturer");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfTypeIsNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setType(null);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "type");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfTypeIsNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setType("atleast3");
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "type");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfTypeIsNotAtLeast3characters() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setType("er");
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "type");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfTypeIs3characters() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setType("aaa");
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "type");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfPriceMinimum() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setPrice(0);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "price");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfPriceMinimum() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setPrice(10);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "price");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfColorisNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setColor(MyColorEnum.BLUE);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "color");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfColorisNull() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setColor(null);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "color");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseOfNegativeNumber() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setCount(-10);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "count");
        assertEquals(1, violation.size());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseOfNegativeNumber() {
        DeviceEntity d1 = new DeviceEntity();
        d1.setCount(10);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validateProperty(d1, "count");
        assertEquals(0, violation.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseIfAppleColor() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        d1.setCount(10);
        d1.setPrice(10000);
        d1.setType("sometype");
        d1.setManufacturer(ManufacturerEnum.APPLE);
        d1.setColor(MyColorEnum.BLUE);
        Set<ConstraintViolation<DeviceEntity>> violations = validator.validate(d1);
        assertEquals(1, violations.size());
        assertEquals("{ManufacturerExaminer.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldNotRaiseConstraintViolationCauseIfAppleColor() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        d1.setCount(10);
        d1.setPrice(10000);
        d1.setType("sometype");
        d1.setManufacturer(ManufacturerEnum.APPLE);
        d1.setColor(MyColorEnum.BLACK);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validate(d1);
        assertEquals(0, violation.size());
    }
     @Test
    public void shouldNotRaiseConstraintViolationCauseIfAppleColor2() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        d1.setCount(10);
        d1.setPrice(10000);
        d1.setType("sometype");
        d1.setManufacturer(ManufacturerEnum.APPLE);
        d1.setColor(MyColorEnum.WHITE);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validate(d1);
        assertEquals(0, violation.size());
    }
    @Test
    public void shouldRaiseConstraintViolationCauseIfSamsungColor() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        d1.setCount(10);
        d1.setPrice(10000);
        d1.setType("sometype");
        d1.setManufacturer(ManufacturerEnum.SAMSUNG);
        d1.setColor(MyColorEnum.GREEN);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validate(d1);
        assertEquals(1, violation.size());
        assertEquals("{ManufacturerExaminer.message}", violation.iterator().next().getMessageTemplate());
    }
    @Test
    public void shouldNotRaiseConstraintViolationCauseIfSamsungColor() {
        String randomUUID = UUID.randomUUID().toString();
        DeviceEntity d1 = new DeviceEntity();
        d1.setId(randomUUID);
        d1.setCount(10);
        d1.setPrice(10000);
        d1.setType("sometype");
        d1.setManufacturer(ManufacturerEnum.SAMSUNG);
        d1.setColor(MyColorEnum.BLUE);
        Set<ConstraintViolation<DeviceEntity>> violation = validator.validate(d1);
        assertEquals(0, violation.size());
    }
    
}
