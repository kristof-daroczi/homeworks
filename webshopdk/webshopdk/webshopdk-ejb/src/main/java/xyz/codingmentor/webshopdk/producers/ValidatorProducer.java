package xyz.codingmentor.webshopdk.producers;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.webshopdk.qualifiers.ValidatorQualifier;

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
