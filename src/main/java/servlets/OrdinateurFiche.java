package servlets;

import entity.Ordinateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrdinateurFiche", urlPatterns = "/ordinateur/*")
public class OrdinateurFiche extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathSubstring = request.getPathInfo().substring(1);
        int id = Integer.parseInt(pathSubstring);
        List<Ordinateur> mesOrdinateurs = new ArrayList<>();

        try {
            mesOrdinateurs.add(Ordinateur.findOne(id));
            request.setAttribute("ordinateurs", mesOrdinateurs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurfiche.jsp").forward(request, response);
    }
}
