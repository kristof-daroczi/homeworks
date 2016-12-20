/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csak.igy.fogadja.el.a.sonar;

import java.util.GregorianCalendar;

/**
 *
 * @author Krisz
 */
public class Main {
    private Main(){
    //#justsonarthings
    }

    public static void main(String[] args) {

        Book b1 = new Book("Microsoft", new GregorianCalendar(1990, 1, 1), 200, "Bill Gates", false);


        Journal j1 = new Journal("Times", new GregorianCalendar(2015, 1, 10), 10, "John Doe", false);
        Journal j2 = new Journal("Blikk", new GregorianCalendar(2014, 3, 17), 11, "Zoltan Nagy", false);
        Journal j3 = new Journal("Gazeta", new GregorianCalendar(2013, 4, 22), 12, "Igor Petruskin", false);

        LibraryDiary instance = LibraryDiary.getInstance();
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 1, 12));
        instance.addReturn(b1, "Béla", new GregorianCalendar(2015, 1, 13), new GregorianCalendar(2015, 1, 15));
        instance.addBorrow(j1, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 1, 12));
        instance.addReturn(j1, "Béla", new GregorianCalendar(2015, 1, 13), new GregorianCalendar(2015, 1, 15));
        instance.addBorrow(j2, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 1, 12));
        instance.addReturn(j2, "Béla", new GregorianCalendar(2015, 1, 13), new GregorianCalendar(2015, 1, 15));
        instance.addBorrow(j3, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 1, 12));
        instance.addReturn(j3, "Béla", new GregorianCalendar(2015, 1, 13), new GregorianCalendar(2015, 1, 15));
        
    }

}
