/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.project.classes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Krisz
 */
 public abstract class Document {

    private String name;
    private GregorianCalendar date;
    private int pages;
    private String author;
    private boolean isBorrowed;
    private List<LibraryLog> libLogs;

    public Document(String name, GregorianCalendar date, int pages, String author, boolean isBorrowed) {
        this.name = name;
        this.date = date;
        this.pages = pages;
        this.author = author;
        this.isBorrowed = isBorrowed;
        libLogs=new LinkedList<>();
    }

    public List<LibraryLog> getLibLogs() {
        return libLogs;
    }

    public void setLibLogs(List<LibraryLog> libLogs) {
        this.libLogs = libLogs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

   
    @Override
    public String toString() {
        return "Document{" + "name=" + name + ", date=" + date.get(Calendar.YEAR) + "." + date.get(Calendar.MONTH) + "." + date.get(Calendar.DAY_OF_MONTH) + ", pages=" + pages + ", author=" + author + ", isBorrowed=" + isBorrowed + '}';
    }

}
