/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kft_hw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Krisz
 */
public class KFT {

    private String seat;
    private String name;
    private List<Worker> workers;
    private List<Boss> bosses;
    private int money;

    public KFT(String seat, String name, int money) {
        this.seat = seat;
        this.name = name;
        this.money = money;
        workers = new LinkedList<>();
        bosses = new LinkedList<>();
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Boss> getBosses() {
        return bosses;
    }

    public void setBosses(List<Boss> bosses) {
        this.bosses = bosses;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addPaymentForWorker(Worker worker, int sum) {
        worker.getPayment(sum);
        System.out.println("Worker has been paid. Name: " + worker.getName() + ", Company budget: " + this.money);
    }

    public void addPaymentForBoss(Boss boss, int sum) {
        boss.getPayment(sum);
        System.out.println("Boss has been paid. Name: " + boss.getName() + ", Company budget: " + this.money);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
        System.out.println("Worker added to workers list. Name: " + worker.name);
    }

    public void addBoss(Boss boss) {
        bosses.add(boss);
        System.out.println("Boss added to bosses list. Name: " + boss.name);
    }

    public void quitBoss(Boss boss) { 
        for (Boss b : bosses) {
            if (b.equals(boss)) {
                bosses.remove(b);
            }
        }
     
        
    }
    public void sackBoss(Boss boss) { 
        for (Boss b : bosses) {
            if (b.equals(boss)) {
                bosses.remove(b);
            }
        }
        System.out.println("Boss has been sacked. Name: "+boss.name);
        
    }

    public void sackWorker(Worker worker) {
        for(Worker w: workers)
        {
            if (w.equals(worker)) {
                workers.remove(w);
            }
        }
        System.out.println("Worker has been sacked. Name: "+worker.name);
    }
    
     public void quitWorker(Worker worker) {
        for(Worker w: workers)
       {
            if (w.equals(worker)) {
                workers.remove(w);
            }
        }
    }
    public void printWorkers()
    {
     System.out.println("Workers of " + this.name + " :");
        for (Worker w : workers) {
            System.out.print(w.name + ", ");
        }
        System.out.println();
    }

    public void printBosses() {
        System.out.println("Bosses of " + this.name + " :");
        for (Boss b : bosses) {
            System.out.print(b.name + ", ");
        }
        System.out.println();
    }

}
