package xyz.codingmentor.firsteehomework.interceptors;

import xyz.codingmentor.firsteehomework.exceptions.ValidationException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import xyz.codingmentor.firsteehomework.annotations.BeanConnector;
import xyz.codingmentor.firsteehomework.qualifiers.ValidatorQualifier;

/**
 *
 * @author Krisz
 */
@Interceptor
@BeanValidation
public class ValidatorInterceptor {

    private static final Logger LOGGER = Logger.getLogger(ValidatorInterceptor.class.getName());

    @Inject @ValidatorQualifier
    private Validator validator;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        validateParameters(ic.getParameters());
        return ic.proceed();

    }

    private void validateBean(Object bean) {
        Set<ConstraintViolation<Object>> violations = validator.validate(bean);
        if (!violations.isEmpty()) {
            LOGGER.log(Level.SEVERE, "Bad validation");
            throw new ValidationException();
        }
    }

    private void validateParameters(Object[] parameters) {
        boolean isValid;
        for (Object parameter : parameters) {
            isValid = parameter.getClass().isAnnotationPresent(BeanConnector.class);
            if (isValid) {
                validateBean(parameter);
            }
        }
    }
}
