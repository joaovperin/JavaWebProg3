/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.core;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract Servlet
 *
 * @author joaovperin
 */
public abstract class SimpleServlet extends HttpServlet {

    /** JSP base folder */
    private static final String BASE_JSP = "/WEB-INF/jsp/";

    /**
     * Get request handler
     *
     * @param req
     * @param resp
     * @throws ServletException
     */
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    }

    /**
     * Post request handler
     *
     * @param req
     * @param resp
     * @throws ServletException
     */
    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    }

    /**
     * Put request handler
     *
     * @param req
     * @param resp
     * @throws ServletException
     */
    public void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    }

    /**
     * Forwards to a page (jsp)
     *
     * @param where
     * @param req
     * @param resp
     * @throws ServletException
     */
    public final void forward(String where, HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(BASE_JSP + where.replaceFirst("/", ""));
        try {
            rd.forward(req, resp);
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }
//******----------------------------------------------***//
//****** Servlet methods *****//
//******----------------------------------------------***//

    @Override
    protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        get(req, resp);
    }

    @Override
    protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        post(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        put(req, resp);
    }

}
