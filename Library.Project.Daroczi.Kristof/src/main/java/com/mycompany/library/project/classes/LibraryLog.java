/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.project.classes;

import java.util.GregorianCalendar;

/**
 *
 * @author Krisz
 */
public class LibraryLog {
    String borrowerName;
    GregorianCalendar borrowDate;
    GregorianCalendar returnDate;

    public LibraryLog(String borrowerName, GregorianCalendar borrowDate, GregorianCalendar returnDate) {
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

  

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public GregorianCalendar getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(GregorianCalendar borrowDate) {
        this.borrowDate = borrowDate;
    }

    public GregorianCalendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(GregorianCalendar returnDate) {
        this.returnDate = returnDate;
    }

   
    
    
    
}
