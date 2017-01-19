package xyz.codingmentor.asynchw;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Krisz
 */
@Path("/async")
@Produces(MediaType.TEXT_PLAIN)
public class AsyncRESTService {

    private static final Logger LOGGER = Logger.getLogger(AsyncRESTService.class.getName());

    private AsyncExample asyncExample = new AsyncExample();

    /**
     * Kreativitásom ezen a téren hagy némi kívánnivalót maga után,mindkét
     * metódusom csak altatja a szálakat: a void-osnál be lehet állítani,hogy
     * meddig aludjon(és kiírja az eredményt),a future-nél meg random generálja
     * az alvási időt,majd kiírja az eredményt. link a voidhoz:
     * http://localhost:8080/asynchwdk-web/webresources/async/1000 link a
     * futurehoz: http://localhost:8080/asynchwdk-web/webresources/async/future
     */
    @GET
    @Path("/{time}")
    public String voidExample(@PathParam("time") int time) {
        asyncExample.makeThreadSleep(time);
        LOGGER.log(Level.INFO, "Async void is OK");
        return "Thread has slept " + time + " millisecs";
    }

    @GET
    @Path("/future")
    public String futureExample() {
        String returnString="";
        try {
            Future<String> text = asyncExample.makeThreadSleepAndReturnString();
            LOGGER.log(Level.INFO, "Async future is OK");
             returnString=text.get();
        } catch (InterruptedException | ExecutionException iex) {
            Logger.getLogger(AsyncRESTService.class.getName()).log(Level.SEVERE, null, iex);
        }
       return returnString;
    }
}
