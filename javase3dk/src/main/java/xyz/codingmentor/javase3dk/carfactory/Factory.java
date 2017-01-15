package xyz.codingmentor.javase3dk.carfactory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krisz
 */
public class Factory {

    private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

    private final List<Part> parts;

    public Factory() {
        parts = new LinkedList<>();
    }

    private static String currentTime() {
        Date currenttime = new Date();
        return currenttime.toString();
    }

    private List<Class> defectiveClasses(List<Class> classes) {
        List<Class> defClasses = new LinkedList<>();
        for (final Class act : classes) {
            if ((act.getAnnotation(DefectivePart.class)) != null) {
                defClasses.add(act);
            }
        }
        return defClasses;
    }
    
    public void getDefectiveParts() {
         List<Class> classes = new LinkedList<>();
         classes.add(PowerWindowMotor.class);
         classes.add(TurnSignal.class);
         classes.add(Gear.class);
         classes.add(Mirror.class);
         classes = defectiveClasses(classes);
         LOGGER.log(Level.INFO, "Defective parts:");
         for (Part act : parts) {
             if (classes.contains(act.getClass())) {
                 LOGGER.log(Level.INFO, "Part type: {0} Car type: {1}", new Object[]{act.getClass().getName(), act.toString()});
             }
         }
     }

    public void makePart(CarType cartype, PartType parttype) {
        Part part;
        switch (parttype) {
            case MIRROR:
                part = new Mirror(cartype.toString());
                parts.add(part);
                LOGGER.log(Level.INFO,currentTime());
                break;
            case GEAR:
                part = new Gear(cartype.toString());
                parts.add(part);
                LOGGER.log(Level.INFO,currentTime());
                break;
            case POWERWINDOWMOTOR:
                part = new PowerWindowMotor(cartype.toString());
                parts.add(part);
                LOGGER.log(Level.INFO,currentTime());
                break;
            case TURNSIGNAL:
                part = new TurnSignal(cartype.toString());
                parts.add(part);
                LOGGER.log(Level.INFO,currentTime());
                break;
            default:
                LOGGER.log(Level.INFO, "Cannot make a part.");
        }
    }

}
