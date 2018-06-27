package br.jpe.prog3.controller;

import br.jpe.prog3.core.SimpleServlet;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Triangles page controller
 *
 * @author joaovperin
 */
@WebServlet("/triangle")
public class TrianglesCtrl extends SimpleServlet {

    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        forward("triangles/index.jsp", req, resp);
    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        // Retrieve parameters and calculates the hipotenuse
        String ca = req.getParameter("tri-ca");
        String co = req.getParameter("tri-co");
        String h = req.getParameter("tri-hi");
        // Adds the responses
        Map<String, Object> map = newMap();
        map.put("catetoAdjascente", ca);
        map.put("catetoOposto", co);
        map.put("hipotenusa", h);
        // Adds a message
        final String realHipo = calculateHipotenuse(ca, co);
        if (realHipo != null && realHipo.equals(h)) {
            map.put("msg", "A hipotenusa está correta!");
        } else {
            map.put("errorMsg", "Resposta errada! A hipotenusa correta é '" + realHipo + "'.");
        }
        // Redirects
        forward("triangles/index.jsp", req, resp, map);
    }

    /**
     * Calculate the hipotenuse
     *
     * @param ca
     * @param co
     * @return String
     */
    private String calculateHipotenuse(String ca, String co) {
        try {
            double nCa = Double.valueOf(ca);
            double nCo = Double.valueOf(co);
            String h = String.valueOf(Math.pow(nCa * nCa + nCo * nCo, 0.5));
            return h.endsWith(".0") ? h.substring(0, h.indexOf(".")) : h;
        } catch (Exception e) {
            return null;
        }
    }

}
