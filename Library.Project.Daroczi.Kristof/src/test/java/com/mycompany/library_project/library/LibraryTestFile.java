/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library_project.library;

import library.project.classes.LibraryDiary;
import library.project.classes.Book;
import library.project.classes.Journal;
import library.project.classes.BookIsBorrowedException;
import java.util.GregorianCalendar;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krisz
 */
public class LibraryTestFile {

    LibraryDiary instance;

    public LibraryTestFile() {

    }

    @Before
    public void init() {
        instance = LibraryDiary.getInstance(); 
    }

    @Test
    public void addBookBorrow() {

        Book b1 = new Book("Microsoft", new GregorianCalendar(1990, 1, 1), 200, "Bill Gates", false);
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 1, 12));
        assertEquals(1, b1.getLibLogs().size());
    }

    @Test
    public void addJournalBorrow() {

        Journal j1 = new Journal("Times", new GregorianCalendar(2015, 1, 10), 10, "John Doe", false);
        instance.addBorrow(j1, "Béla", new GregorianCalendar(2015, 1, 10), new GregorianCalendar(2015, 01, 12));
        assertEquals(1, j1.getLibLogs().size());
    }

    @Test
    public void addMultipleLibraryLogs() {

        Book b1 = new Book("Microsoft", new GregorianCalendar(1990, 01, 01), 200, "Bill Gates", false);
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addReturn(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 02, 10), new GregorianCalendar(2015, 02, 12));
        instance.addReturn(b1, "Béla", new GregorianCalendar(2015, 02, 10), new GregorianCalendar(2015, 02, 12));
        assertEquals(4, b1.getLibLogs().size());

        Journal j1 = new Journal("Times", new GregorianCalendar(2015, 01, 10), 10, "John Doe", false);
        instance.addBorrow(j1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addReturn(j1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        assertEquals(2, j1.getLibLogs().size());

    }

    @Test(expected = BookIsBorrowedException.class)
    public void addBorrowAnBorrowedItem() {
        Book b1 = new Book("Microsoft", new GregorianCalendar(1990, 01, 01), 200, "Bill Gates", false);
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
    }

    @Test
    public void numberofItemsInLogs() {
        Book b1 = new Book("Microsoft", new GregorianCalendar(1990, 01, 01), 200, "Bill Gates", false);
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addReturn(b1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addBorrow(b1, "Béla", new GregorianCalendar(2015, 02, 10), new GregorianCalendar(2015, 02, 12));
        instance.addReturn(b1, "Béla", new GregorianCalendar(2015, 02, 10), new GregorianCalendar(2015, 02, 12));

        Journal j1 = new Journal("Times", new GregorianCalendar(2015, 01, 10), 10, "John Doe", false);
        instance.addBorrow(j1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        instance.addReturn(j1, "Béla", new GregorianCalendar(2015, 01, 10), new GregorianCalendar(2015, 01, 12));
        assertThat(instance.getLogs().size(), is(2));

        assertEquals(2, instance.getLogs().get(j1).size());
        assertEquals(4, instance.getLogs().get(b1).size());
    }

}
