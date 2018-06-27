package br.jpe.prog3.controller;

import br.jpe.prog3.core.EntityManager;
import br.jpe.prog3.core.Parse;
import br.jpe.prog3.core.Query;
import br.jpe.prog3.core.SimpleServlet;
import br.jpe.prog3.model.User;
import java.util.Date;
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

    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        Map map = newMap();
        map.put("users", getUsers());
        forward("users/index.jsp", req, resp, map);
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        // Retrieve parameters and calculates the hipotenuse
        String nome = req.getParameter("usr-nome");
        String email = req.getParameter("usr-email");
        String pass = req.getParameter("usr-pass");
        String birth = req.getParameter("usr-birth");

        Date parsedDate = Parse.toDate(birth);

        User usr = new User();
        usr.setNome(nome);
        usr.setEndEmail(email);
        usr.setSenha(pass);
        usr.setDtNascimento(parsedDate);
        usr.setDtInclusao(new Date());

        // Adds the responses
        Map<String, Object> map = newMap();
        // Adds a message
        if (nome == null || email == null || pass == null || birth == null || parsedDate == null) {
            map.put("errorMsg", "Dados inválidos!");
        } else {
            if (EntityManager.persist(usr)) {
                map.put("msg", "Gravado com sucesso!!");
            } else {
                map.put("errorMsg", "Falha ao gravar usuário '" + usr.getNome() + "' no banco.");
            }
        }
        // Redirects
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
