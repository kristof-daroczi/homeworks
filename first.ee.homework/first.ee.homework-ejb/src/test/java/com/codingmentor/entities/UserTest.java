package com.codingmentor.entities;

import com.codingmentor.entities.UserEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.ParameterNameProvider;
import javax.validation.TraversableResolver;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorContext;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krisz
 */
public class UserTest {
    
    private static ValidatorFactory vf;
    private static javax.validation.Validator validator;
    
    public UserTest() {
    }
    
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
    public void shouldNotRaiseViolationCauseUsernameisNotNull() {
        UserEntity u1 = new UserEntity();
        u1.setUsername("examplename");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "username");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseUsernameisNull() {
        UserEntity u1 = new UserEntity();
        u1.setUsername(null);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "username");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseUsernameis6chars() {
        UserEntity u1 = new UserEntity();
        u1.setUsername("examplename");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "username");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseUsernameisNot6chars() {
        UserEntity u1 = new UserEntity();
        u1.setUsername("ex");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "username");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCausePasswordisNull() {
        UserEntity u1 = new UserEntity();
        u1.setPassword(null);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "password");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCausePasswordisNotNull() {
        UserEntity u1 = new UserEntity();
        u1.setPassword("Example9");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "password");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCausePasswordisInvalid() {
        UserEntity u1 = new UserEntity();
        u1.setPassword("invalidpass1223");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "password");
        assertEquals(1, violation.size());
        
        u1.setPassword("invalidpass");
        Set<ConstraintViolation<UserEntity>> violation2 = validator.validateProperty(u1, "password");
        assertEquals(2, violation2.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCausePasswordisInvalid() {
        UserEntity u1 = new UserEntity();
        u1.setPassword("validPass1");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "password");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseofPhoneNumber() {
        UserEntity u1 = new UserEntity();
        u1.setPhone("+36305741290");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "phone");
        assertEquals(0, violation.size());
        
        u1.setPhone("06305741290");
        Set<ConstraintViolation<UserEntity>> violation2 = validator.validateProperty(u1, "phone");
        assertEquals(0, violation2.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseofPhoneNumber() {
        UserEntity u1 = new UserEntity();
        u1.setPhone("5741290");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "phone");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseEmail() {
        UserEntity u1 = new UserEntity();
        u1.setEmail("dkristoff@hotmail.com");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "email");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseOfInvalidEmail() {
        UserEntity u1 = new UserEntity();
        u1.setEmail("really,invalid@mail!com.com");
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "email");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseOfRegDateisNull() {
        UserEntity u1 = new UserEntity();
        u1.setRegistrationDate(null);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "registrationDate");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfRegDateisNotNull() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        Date testDate = calendar.getTime();
        u1.setRegistrationDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "registrationDate");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseOfLastModDateisNull() {
        UserEntity u1 = new UserEntity();
        u1.setLastModifiedDate(null);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "lastModifiedDate");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfLastModDateisNotNull() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        Date testDate = calendar.getTime();
        u1.setLastModifiedDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "lastModifiedDate");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfLastModDateisInPast() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        Date testDate = calendar.getTime();
        u1.setLastModifiedDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "lastModifiedDate");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldRaiseViolationCauseOfLastModDateisInFuture() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2019, 2, 13);
        Date testDate = calendar.getTime();
        u1.setLastModifiedDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "lastModifiedDate");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfRegDateisInPast() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        Date testDate = calendar.getTime();
        u1.setRegistrationDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "registrationDate");
        assertEquals(0, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfRegDateisInFuture() {
        UserEntity u1 = new UserEntity();
        GregorianCalendar calendar = new GregorianCalendar(2022, 2, 13);
        Date testDate = calendar.getTime();
        u1.setRegistrationDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validateProperty(u1, "registrationDate");
        assertEquals(1, violation.size());
    }
    
    @Test
    public void shouldNotRaiseViolationCauseOfNames() {
       GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        GregorianCalendar calendar2 = new GregorianCalendar(1990, 2, 13);
        Date testDate = calendar.getTime();
        Date birthdate=calendar2.getTime();
        UserEntity u1 = new UserEntity();
        u1.setFirstname(null);
        u1.setLastname(null);
        u1.setAddress("01234example");
        u1.setEmail("kiskutya@gmail.com");
        u1.setPassword("Password3");
        u1.setUsername("ustertest");
        u1.setPhone("+36705411122");
        u1.setLastModifiedDate(testDate);
        u1.setRegistrationDate(testDate);
        u1.setDateOfBirth(birthdate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validate(u1);
        assertEquals(0, violation.size());
        
        u1.setFirstname("John");
        u1.setLastname("Doe");
        Set<ConstraintViolation<UserEntity>> violation2 = validator.validate(u1);
        assertEquals(0, violation2.size());
    }
    
       @Test
    public void shouldRaiseViolationCauseOfNames() {
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        GregorianCalendar calendar2 = new GregorianCalendar(1990, 2, 13);
        Date testDate = calendar.getTime();
        Date birthdate=calendar2.getTime();;
        UserEntity u1 = new UserEntity();
        u1.setFirstname("John");
        u1.setLastname(null);
        u1.setAddress("01234example");
        u1.setEmail("kiskutya@gmail.com");
        u1.setPassword("Password3");
        u1.setUsername("ustertest");
        u1.setPhone("+36705411122");
        u1.setLastModifiedDate(testDate);
        u1.setRegistrationDate(testDate);
        u1.setDateOfBirth(birthdate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validate(u1);
        assertEquals(1, violation.size());
        
        u1.setFirstname("John");
        u1.setLastname(null);
        Set<ConstraintViolation<UserEntity>> violation2 = validator.validate(u1);
        assertEquals(1, violation2.size());
    }
    @Test
    public void shouldNotRaiseViolationCauseOfBirthdate() {
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        GregorianCalendar calendar2 = new GregorianCalendar(1990, 2, 13);
        Date testDate = calendar.getTime();
        Date birthdate=calendar2.getTime();
        UserEntity u1 = new UserEntity();
        u1.setFirstname("John");
        u1.setLastname("Doe");
        u1.setAddress("01234example");
        u1.setEmail("kiskutya@gmail.com");
        u1.setPassword("Password3");
        u1.setUsername("ustertest");
        u1.setPhone("+36705411122");
        u1.setDateOfBirth(birthdate);
        u1.setLastModifiedDate(testDate);
        u1.setRegistrationDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validate(u1);
        assertEquals(0, violation.size());
           
    }
    @Test
    public void shouldRaiseViolationCauseOfBirthdate() {
        GregorianCalendar calendar = new GregorianCalendar(2012, 2, 13);
        GregorianCalendar calendar2 = new GregorianCalendar(2013, 2, 13);
        Date testDate = calendar.getTime();
        Date birthdate=calendar2.getTime();
        UserEntity u1 = new UserEntity();
        u1.setFirstname("John");
        u1.setLastname("Doe");
        u1.setAddress("01234example");
        u1.setEmail("kiskutya@gmail.com");
        u1.setPassword("Password3");
        u1.setUsername("ustertest");
        u1.setPhone("+36705411122");
        u1.setDateOfBirth(birthdate);
        u1.setLastModifiedDate(testDate);
        u1.setRegistrationDate(testDate);
        Set<ConstraintViolation<UserEntity>> violation = validator.validate(u1);
        assertEquals(1, violation.size());
           
    }
}
