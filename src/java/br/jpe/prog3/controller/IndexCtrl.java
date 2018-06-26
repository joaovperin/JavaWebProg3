/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.prog3.controller;

import br.jpe.prog3.core.SimpleServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Index page controller
 *
 * @author joaovperin
 */
@WebServlet("")
public class IndexCtrl extends SimpleServlet {

    /**
     * Answers to Get responses.
     *
     * @param req
     * @param resp
     * @throws ServletException
     */
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        forward("index.jsp", req, resp);
    }

}
