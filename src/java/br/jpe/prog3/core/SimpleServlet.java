package br.jpe.prog3.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        forward(where, req, resp, null);
    }

    /**
     * Forwards to a page (jsp) adding parameters
     *
     * @param where
     * @param req
     * @param resp
     * @param map
     * @throws ServletException
     */
    public final void forward(String where, HttpServletRequest req, HttpServletResponse resp, Map<String, Object> map) throws ServletException {
        // Adds parameters
        addDefaultParametersToRequest(req);
        if (map != null && !map.isEmpty()) {
            map.forEach(req::setAttribute);
        }
        // Sends redirect
        RequestDispatcher rd = req.getServletContext().getRequestDispatcher(normalizePath(where));
        try {
            rd.forward(req, resp);
        } catch (IOException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Creates a map
     *
     * @return Map
     */
    public final Map<String, Object> newMap() {
        return new HashMap<>();
    }

    /**
     * Normalizes a path
     *
     * @param path
     * @return String
     */
    private String normalizePath(String path) {
        String s = path;
        if (path.startsWith("/")) {
            s = path.replaceFirst("/", "");
        }
        return BASE_JSP + s;
    }

    /**
     * Adds default parameters to request
     *
     * @param request
     */
    private void addDefaultParametersToRequest(HttpServletRequest request) {
        request.setAttribute("basePath", "/JavaWebProg3");
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
