package com.codingmentor.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Krisz
 */

@Constraint(validatedBy = BirthdateExaminerValidator.class)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface BirthdateExaminer {
     String message() default "{BirthdayExaminer.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
