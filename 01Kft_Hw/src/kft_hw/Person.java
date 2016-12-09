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
abstract public class Person {
    
    protected String name;
    protected String gender;
    protected int money;
    protected LocalDateTime birthdate;
    protected KFT kft;
    
    public Person(String name, String gender, int money, LocalDateTime birthdate, KFT kft) {
        this.name = name;
        this.gender = gender;
        this.money = money;
        this.birthdate = birthdate;
        this.kft = kft;
    }

    protected void getPayment(int sum) {
        kft.setMoney(kft.getMoney() - sum);
        this.money += sum;
        System.out.println(name + "has got his payment. Current money: " + money);
    }

    abstract public void doJob();

    abstract public void quitJob();
    
}
