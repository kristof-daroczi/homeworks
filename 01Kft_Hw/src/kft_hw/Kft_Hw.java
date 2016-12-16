/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kft_hw;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 *
 * @author Krisz
 */
public class Kft_Hw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KFT k1 = new KFT("Budapest", "DoSomethingKFT", 100000000);

        Worker w1 = new Worker("Béla", "male", 10000, LocalDateTime.of(1992, Month.JANUARY, 20, 12, 13), k1);
        Worker w2 = new Worker("Zoli", "male", 20000, LocalDateTime.of(1992, Month.JANUARY, 20, 12, 13), k1);
        Worker w3 = new Worker("Máté", "male", 30000, LocalDateTime.of(1992, Month.JANUARY, 20, 12, 13), k1);
        w1.doJob();
        w2.doJob();
        k1.addWorker(w2);
        k1.addWorker(w1);
        k1.addWorker(w3);
        
        Boss b1 = new Boss("Zsolt", "male", 50000, LocalDateTime.of(1976, Month.DECEMBER, 3, 11, 11), k1);
        Boss b2 = new Boss("Endre", "male", 70000, LocalDateTime.of(1976, Month.DECEMBER, 3, 11, 11), k1);
        Boss b3 = new Boss("Zsanett", "female", 80000, LocalDateTime.of(1976, Month.DECEMBER, 3, 11, 11), k1);
        b1.doJob();
        k1.addBoss(b1);
        k1.addBoss(b2);
        k1.addBoss(b3);
        k1.printBosses();
        
        k1.sackBoss(b1);
        k1.printBosses();
        //b2.quitJob();
        k1.printBosses();
        k1.addPaymentForWorker(w2, 2000);
        k1.addPaymentForBoss(b2, 3000);
        k1.printWorkers();
        k1.sackWorker(w2);
        w1.quitJob();
        k1.printWorkers();
        
        
    }

}
