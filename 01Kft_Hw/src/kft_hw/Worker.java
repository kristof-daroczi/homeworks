/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kft_hw;

import java.time.LocalDateTime;

/**
 *
 * @author Krisz
 */
class Worker extends Person {

    public Worker(String name, String gender, int money, LocalDateTime birthdate, KFT kft) {
        super(name, gender, money, birthdate, kft);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public void doJob() {
        System.out.println("Job (worker) done by :" + this.name);
    }

    @Override
    public void quitJob() {
        System.out.println("Worker " + this.name + " quited the job.");
        kft.quitWorker(this);
        
    }
    
}
