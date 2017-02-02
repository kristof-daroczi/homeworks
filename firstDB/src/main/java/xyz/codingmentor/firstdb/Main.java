package xyz.codingmentor.firstdb;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.firstdb.api.RepositoryException;

/**
 *
 * @author Krisz
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws xyz.codingmentor.firstdb.api.RepositoryException
     */
    private Main() {
        //empty on purpose
    }

    public static void main(String[] args) throws RepositoryException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        Application application = container.instance().select(Application.class).get();
        application.execute();

        weld.shutdown();

    }

}
