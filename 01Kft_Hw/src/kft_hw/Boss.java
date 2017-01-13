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
class Boss extends Person {

    public Boss(String name, String gender, int money, LocalDateTime birthdate, KFT kft) {
        super(name, gender, money, birthdate, kft);
    }

    @Override
    public void doJob() {
        System.out.println("Job (boss) done by :" + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void quitJob() {
        System.out.println("Boss " + this.name + " quited the job.");
        kft.quitBoss(this);

    }
    //kirúgat
}
