package xyz.codingmentor.firsteehomework.exceptions;

/**
 *
 * @author Krisz
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {
        //empty on purpose
    }

    public ValidationException(String errorMessages) {
        super(errorMessages);
    }

}
