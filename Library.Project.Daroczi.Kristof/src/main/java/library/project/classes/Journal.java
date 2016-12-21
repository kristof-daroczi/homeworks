/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.project.classes;

import java.util.GregorianCalendar;

/**
 *
 * @author Krisz
 */
public class Journal extends Document {
  
    public Journal(String name, GregorianCalendar date, int pages, String author, boolean isBorrowed) {
        super(name, date, pages, author, isBorrowed);
    }
  
    
  
    
}
