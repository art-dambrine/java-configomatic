package servlets;


import entity.Ordinateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DeleteOrdinateur", urlPatterns = "/deleteordinateur/*")
public class DeleteOrdinateur extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String pathSubstring = request.getPathInfo().substring(1);
        int id = Integer.parseInt(pathSubstring);
        Boolean isValid = false;
        try {
            isValid = Ordinateur.deleteOne(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        PrintWriter out = response.getWriter();

        if (isValid) {
            out.print("{\"message\":\"ok\"}");
            response.setStatus(202);
            System.out.println("Ordinateur.deleteOne OK");
        } else {
            out.print("{\"message\":\"Une erreur est survenue dans la requête.\"}");
            response.setStatus(500);
            System.out.println("Erreur execution Ordinateur.createOne");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
