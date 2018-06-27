/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

/**
 * A Simple SQL Query wrapper
 *
 * @author joaovperin
 */
public class Query {

    /** Query SQL */
    public final String sql;

    /**
     * Constructor
     *
     * @param sql
     */
    public Query(String sql) {
        this.sql = sql;
    }

}
