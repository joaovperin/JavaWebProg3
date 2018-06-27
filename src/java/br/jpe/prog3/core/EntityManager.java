/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages entities
 *
 * @author joaovperin
 */
public class EntityManager {

    /**
     * Don't allow instantiations
     */
    private EntityManager() {
        throw new IllegalStateException("Cannot be instantiated.");
    }

    /**
     * Executes a query
     *
     * @param <E> Entity type
     * @param query Query
     * @param E Model class
     * @return List
     */
    public static <E> List<E> query(Query query, Class<? extends Model> E) {
        List<E> list = new ArrayList<>();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            c = ConnectionFactory.create();
            st = c.createStatement();
            rs = st.executeQuery(query.sql);
            while (rs.next()) {
                list.add((E) E.newInstance().get(rs));
            }
            return list;
        } catch (ReflectiveOperationException | SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(c, st, rs);
            } catch (SQLException ex) {}
        }
        return list;
    }

    /**
     * Persists a model on the database and returns true if it's successful
     *
     * @param model
     * @return boolean
     */
    public static boolean persist(Model model) {
        Connection c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            c = ConnectionFactory.create();
            pstm = c.prepareStatement(model.sqlPersist());
            model.set(pstm);
            pstm.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            if (c != null) {
                try {
                    c.rollback();
                } catch (SQLException ex) {}
            }
        } finally {
            try {
                close(c, pstm, rs);
            } catch (SQLException ex) {}
        }
        return false;
    }

    /**
     * Closes cursors and connections with the database
     *
     * @param conn
     * @param pstm
     * @param rs
     * @throws SQLException
     */
    private static void close(Connection conn, Statement pstm, ResultSet rs) throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

}
