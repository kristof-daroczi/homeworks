package xyz.codingmentor.webshopdk.exceptions;

/**
 *
 * @author Krisz
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {
        super();
    }

    public ValidationException(String errorMessages) {
        super(errorMessages);
    }

}
