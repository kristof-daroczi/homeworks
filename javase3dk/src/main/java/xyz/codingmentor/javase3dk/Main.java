package xyz.codingmentor.javase3dk;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.javase3dk.carfactory.CarType;
import xyz.codingmentor.javase3dk.carfactory.Factory;
import xyz.codingmentor.javase3dk.carfactory.PartType;
import xyz.codingmentor.javase3dk.littletasks.ConfusingAnalisator;
import xyz.codingmentor.javase3dk.littletasks.GenericTree;
import xyz.codingmentor.javase3dk.littletasks.QuickSort;
import xyz.codingmentor.javase3dk.littletasks.NoIdeaInterface;

/**
 *
 * @author Krisz
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Main() {
        //empty for sonar
    }

    public static void main(String[] args) {

        /**
         * Carfactory
         */
        Factory factory = new Factory();
        factory.makePart(CarType.FORD, PartType.GEAR);
        factory.makePart(CarType.FORD, PartType.MIRROR);
        factory.makePart(CarType.FORD, PartType.POWERWINDOWMOTOR);
        factory.makePart(CarType.FORD, PartType.TURNSIGNAL);
        factory.makePart(CarType.AUDI, PartType.GEAR);
        factory.makePart(CarType.AUDI, PartType.MIRROR);
        factory.makePart(CarType.AUDI, PartType.POWERWINDOWMOTOR);
        factory.makePart(CarType.AUDI, PartType.TURNSIGNAL);
        factory.makePart(CarType.MAZDA, PartType.GEAR);
        factory.makePart(CarType.MAZDA, PartType.MIRROR);
        factory.makePart(CarType.MAZDA, PartType.POWERWINDOWMOTOR);
        factory.makePart(CarType.MAZDA, PartType.TURNSIGNAL);
        factory.makePart(CarType.TOYOTA, PartType.GEAR);
        factory.makePart(CarType.TOYOTA, PartType.MIRROR);
        factory.makePart(CarType.TOYOTA, PartType.POWERWINDOWMOTOR);
        factory.makePart(CarType.TOYOTA, PartType.TURNSIGNAL);
        factory.getDefectiveParts();

        /**
         * Quicksort
         */
        Integer[] arr = new Integer[3];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 1;
        for (int i = 0; i < arr.length; i++) {
            LOGGER.log(Level.INFO, arr[i].toString());
        }

        QuickSort.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            LOGGER.log(Level.INFO, arr[i].toString());
        }

        /**
         * Generic tree
         */
        GenericTree<Number> root = new GenericTree<>(6);
        GenericTree<Number> node1 = new GenericTree<>(52);
        root.addChild(node1);
        GenericTree<Number> node2 = new GenericTree<>(43);
        root.addChild(node2);
        GenericTree<Number> node3 = new GenericTree<>(99);
        node2.addChild(node3);
        GenericTree<Number> node4 = new GenericTree<>(19);
        node2.addChild(node4);
        GenericTree<Number> node5 = new GenericTree<>(92);
        node2.addChild(node5);
        GenericTree<Number> node6 = new GenericTree<>(78);
        node3.addChild(node6);
        LOGGER.log(Level.INFO, root.build().toString());

        /**
         * Confusing
         */
        ConfusingAnalisator.analyze(NoIdeaInterface.class);

    }

}
