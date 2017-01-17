package xyz.codingmentor.firsteehomework.producers;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.firsteehomework.qualifiers.ValidatorQualifier;

/**
 *
 * @author Krisz
 */
public class ValidatorProducer {

    @Produces
    @ValidatorQualifier
    public Validator produceValidator() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();

    }

}
