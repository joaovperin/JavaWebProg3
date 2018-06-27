/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parser Service
 *
 * @author joaovperin
 */
public class Parse {

    /** Simple Date Formatter */
    private final static SimpleDateFormat SD_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    /** Simple Date Parser */
    private final static SimpleDateFormat SD_PARSE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Parse() {
        throw new IllegalStateException("Cannot be instantiated.");
    }

    /**
     * String to date
     *
     * @param date
     * @return Date
     */
    public static synchronized Date toDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            try {
                return SD_PARSE.parse(date);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    /**
     * Date to String
     *
     * @param date
     * @return String
     */
    public static synchronized String fromDate(Date date) {
        if (date == null) {
            return "";
        }
        return SD_FORMAT.format(date);
    }

}
