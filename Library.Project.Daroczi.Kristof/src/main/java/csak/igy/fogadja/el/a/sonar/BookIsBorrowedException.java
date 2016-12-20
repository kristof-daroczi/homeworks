/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csak.igy.fogadja.el.a.sonar;

/**
 *
 * @author Krisz
 */
public class BookIsBorrowedException extends RuntimeException {

    public BookIsBorrowedException() {
        //#justsonarthings
    }

    public BookIsBorrowedException(String message) {
        super(message);
    }

    public BookIsBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookIsBorrowedException(Throwable cause) {
        super(cause);
    }

    public BookIsBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
    
    
}
