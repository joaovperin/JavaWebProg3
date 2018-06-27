/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract Model
 *
 * @author joaovperin
 * @param <M>
 */
public abstract class Model<M> {

    /**
     * Returns the SQL for a persistence command
     *
     * @return String
     */
    public abstract String sqlPersist();

    /**
     * Extracts (get) a model from a result set
     *
     * @param rs
     * @return M
     * @throws SQLException
     */
    public abstract M get(ResultSet rs) throws SQLException;

    /**
     * Plots (set) a model on a prepared statement
     *
     * @param pstm
     * @throws SQLException
     */
    public abstract void set(PreparedStatement pstm) throws SQLException;

}
