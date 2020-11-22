package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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

        PrintWriter out = response.getWriter();
        out.print(jsonObject);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
