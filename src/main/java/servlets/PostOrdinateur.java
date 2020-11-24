package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import entity.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "PostOrdinateur", urlPatterns = "/postordinateur")
public class PostOrdinateur extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject jsonObject = getJsonObject(getJsonString(request));

        Ordinateur ordinateur = getOrdinateurFromJson(jsonObject);

        Boolean isValid = createOrdinateurInDatabase(ordinateur);

        if (!isValid) {
            // TODO : response HTTP 500
            response.setStatus(500);
            System.out.println("Erreur execution Ordinateur.createOne");
        } else {
            // TODO : response HTTP 201 created
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            response.setStatus(201);
            System.out.println("Ordinateur.createOne OK");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Boolean createOrdinateurInDatabase(Ordinateur ordinateur) {
        try {
            if ((Ordinateur.createOne(ordinateur)) == 0)
                return false;
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @NotNull
    private Ordinateur getOrdinateurFromJson(JSONObject jsonObject) {
        Processeur processeur = null;
        CarteMere carteMere = null;
        Memoire memoire = null;
        CarteGraphique carteGraphique = null;
        DisqueDur disqueDur = null;

        try {
            processeur = Processeur.findOne(jsonObject.getInt("inputProcesseur"));
            carteMere = CarteMere.findOne(jsonObject.getInt("inputCarteMere"));
            memoire = Memoire.findOne(jsonObject.getInt("inputMemoire"));
            carteGraphique = CarteGraphique.findOne(jsonObject.getInt("inputCarteGraphique"));
            disqueDur = DisqueDur.findOne(jsonObject.getInt("inputDisqueDur"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Float prixTotal = processeur.getPrix() + carteMere.getPrix() + memoire.getPrix() +
                carteGraphique.getPrix() + disqueDur.getPrix();

        Ordinateur ordinateur = new Ordinateur(
                0, processeur, carteMere, memoire, carteGraphique, disqueDur, prixTotal,
                false, null, null);
        return ordinateur;
    }

    @NotNull
    private String getJsonString(HttpServletRequest request) throws IOException {
        /* Recupere le JSON au format String */
        StringBuffer jsonBuffer = new StringBuffer();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
            jsonBuffer.append(line);
        String jsonString = jsonBuffer.toString();
        return jsonString;
    }

    @Nullable
    private JSONObject getJsonObject(String jsonString) {
        /* Recupere le JSON en Java au format JSONObject (necessite librairie json) */
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);  // get jsonObject @ i position
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
