package servlets;

import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "config", urlPatterns = "/config")
public class Config extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("processeurs", Processeur.fetchAll());
            request.setAttribute("cartemeres", CarteMere.fetchAll());
            request.setAttribute("memoires", Memoire.fetchAll());
            request.setAttribute("cartegraphiques", CarteGraphique.fetchAll());
            request.setAttribute("disquedurs", DisqueDur.fetchAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/config.jsp").forward(request, response);
    }
}
