/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Factory for connections
 *
 * @author joaovperin
 */
public class ConnectionFactory {

    /** Databse Connection */
    private static final String CONN = "jdbc:mysql://porto-zoca.cl6eed1myiqo.us-west-2.rds.amazonaws.com:3306/PortoZoca_Dev";
    /** Database Username */
    private static final String USER = "PortoZoca";
    /** Database Password */
    private static final String PASS = "PortoZoca1234";

    /** Control if already registered */
    private static final AtomicBoolean REGISTERED;

    static {
        REGISTERED = new AtomicBoolean(false);
    }

    /**
     * Creates a connection
     *
     * @return Connection
     * @throws SQLException
     */
    public static final synchronized Connection create() throws SQLException {
        // Register if not done yet
        if (!REGISTERED.getAndSet(true)) {
            register();
        }
        // Create and return connection
        Connection conn = DriverManager.getConnection(CONN, USER, PASS);
        conn.setAutoCommit(false);
        conn.setReadOnly(false);
        return conn;
    }

    /**
     * Registers the jdbc Driver
     */
    private static void register() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            REGISTERED.set(false);
        }
    }

}
