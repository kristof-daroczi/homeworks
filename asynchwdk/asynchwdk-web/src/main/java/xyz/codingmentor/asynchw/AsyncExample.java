package xyz.codingmentor.asynchw;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;

/**
 *
 * @author Krisz
 */
@Asynchronous
public class AsyncExample {

    private static final Logger LOGGER = Logger.getLogger(AsyncExample.class.getName());

    public void makeThreadSleep(int millisecs) {
        LOGGER.log(Level.INFO, "Making thread sleep");
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOGGER.log(Level.INFO, "Thread has slept {0} millisecs", millisecs);
    }

    public Future<String> makeThreadSleepAndReturnString() {
        LOGGER.log(Level.INFO, "Making thread sleep");
        Random r = new Random();
        int time = 1000 + r.nextInt(3000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (time < 2500) {
            LOGGER.log(Level.INFO, "Thread has slept less than 2500 millisecs");
            return new AsyncResult<>("Thread has slept less than 2500 millisecs. Time slept: "+time);
        } else {
            LOGGER.log(Level.INFO, "Thread has slept more than 2500 millisecs");
            return new AsyncResult<>("Thread has slept more than 2500 millisecs. Time slept: "+time);
        }
    }

}
