package br.jpe.prog3.controller;

import br.jpe.prog3.core.EntityManager;
import br.jpe.prog3.core.Query;
import br.jpe.prog3.core.SimpleServlet;
import br.jpe.prog3.model.User;
import java.util.List;
import java.util.Map;
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
        Map map = newMap();
        map.put("users", getUsers());
        forward("users/index.jsp", req, resp, map);
    }

    /**
     * Get users on database
     *
     * @return List
     */
    private List<User> getUsers() {
        return EntityManager.query(new Query("SELECT * FROM Usuarios"), User.class);
    }

}
