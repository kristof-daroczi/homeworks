/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library.project.classes;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krisz
 */
public class LibraryDiary {

    private static final Logger LOGGER = Logger.getLogger(LibraryDiary.class.getName());
    private Map<Document, List<LibraryLog>> logs;
    private static LibraryDiary iNSTANCE; //sonar

    private LibraryDiary() {
        logs = new HashMap<>();
    }

    public Map<Document, List<LibraryLog>> getLogs() {
        return logs;
    }

    public void setLogs(Map<Document, List<LibraryLog>> logs) {
        this.logs = logs;
    }


    public static LibraryDiary getInstance() {
        if (iNSTANCE == null) {
            iNSTANCE = new LibraryDiary();
        }
        return iNSTANCE;
    }

    public void addBorrow(Document doc, String name, GregorianCalendar bdate, GregorianCalendar rdate) {
        if (doc.isIsBorrowed()) {
            throw new BookIsBorrowedException();
        } else {
            doc.getLibLogs().add(new LibraryLog(name, bdate, rdate));
            doc.setIsBorrowed(true);
            logs.put(doc, doc.getLibLogs());
        }
    }

    public void addReturn(Document doc, String name, GregorianCalendar bdate, GregorianCalendar rdate) {
        if (doc.isIsBorrowed()) {
            doc.getLibLogs().add(new LibraryLog(name, bdate, rdate));
            doc.setIsBorrowed(false);
            logs.put(doc, doc.getLibLogs());
        } else {
            LOGGER.log(Level.INFO, "Item is not borrowed yet!");
        }

    }

}
