package xyz.codingmentor.javase3dk.littletasks;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krisz
 */
public class ConfusingAnalisator {

    private static final Logger LOGGER = Logger.getLogger(ConfusingAnalisator.class.getName());

    private ConfusingAnalisator() {
        //empty for sonar
    }

    public static void analyze(Class<?> clazz) {
        Confusing annotationClass = clazz.getAnnotation(Confusing.class);
        if (annotationClass != null) {
            LOGGER.log(Level.INFO, "Name of the class/interface: {0}", clazz.getName());
            LOGGER.log(Level.INFO, "Superclass:  {0}", clazz.getSuperclass());
            LOGGER.log(Level.INFO, "Package:  {0}", clazz.getPackage());
        }
    }

}
