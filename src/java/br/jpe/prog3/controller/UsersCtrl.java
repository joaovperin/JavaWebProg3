package br.jpe.prog3.controller;

import br.jpe.prog3.core.SimpleServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Users page controller
 *
 * @author joaovperin
 */
@WebServlet("/users")
public class UsersCtrl extends SimpleServlet {

    /**
     * Answers to Get responses.
     *
     * @param req
     * @param resp
     * @throws ServletException
     */
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        forward("users/index.jsp", req, resp);
    }

}
