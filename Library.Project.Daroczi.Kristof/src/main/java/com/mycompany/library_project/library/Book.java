/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library_project.library;

import java.util.GregorianCalendar;

/**
 *
 * @author Krisz
 */
public class Book extends Document {

    public Book(String name, GregorianCalendar date, int pages, String author, boolean isBorrowed) {
        super(name, date, pages, author, isBorrowed);
    }

    

   

}
