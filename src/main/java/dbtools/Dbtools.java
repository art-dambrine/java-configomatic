package dbtools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class Dbtools {

    private static boolean debug = false;


    public static Connection getConnexion() {
        /*
         * Première étape : trouver le nom du Driver JDBC pour votre SGBD
         * */

        String nomDuDriver = "com.mysql.cj.jdbc.Driver";

        /*
         * 2dn étape : Format des URL JDBC de votre SGBD
         * */

        String urlBD = "jdbc:mysql://127.0.0.1:3666/configomatic";
        String monUser = "configomatic";
        String monPassword = "adminadmin";

        /*
         * Etape n°3 : Charger le driver JDBC de votre SGBD en mémoire
         * */

        try {

            Class.forName(nomDuDriver);
            if (debug) System.out.println("Le driver est chargé en mémoire \n");

        } catch (ClassNotFoundException e) {
            if (debug) System.out.println("Le chargement du driver a échoué \n");
            e.printStackTrace();

            System.exit(3); // On quitte le programme (code a titre exceptionnel!!)
        }


        /*
         * Etape 4 : Elaborer une connexion entre votre programme et le SGBD
         * */

        Connection maConnection = null;

        try {
            maConnection = DriverManager.getConnection(urlBD, monUser, monPassword);
            if (debug) System.out.println("La connexion au SGBD a pu être créee");
        } catch (SQLException throwables) {
            if (debug) System.out.println("La connexion au SGBD a échouée");
            throwables.printStackTrace();
            System.exit(4); // A titre exceptionnel !!!
        }
        return maConnection;
    }

    public static Statement getStatement(Connection maConnection) {
        /*
         * Etape n°5 : Fabrication du Statement ("l'enveloppe")
         * */

        Statement stmt = null;

        try {
            stmt = maConnection.createStatement();
            if (debug) System.out.println("Le statement a été créé avec succès.");
        } catch (SQLException throwables) {
            if (debug) System.out.println("La création du statement a échouée.");
            throwables.printStackTrace();
            if (debug) System.exit(5); // A titre exceptionnel !!!
        }
        return stmt;
    }



    public static int requeteEcritureBase(Statement stmt, String requeteSqlSansSelect) {
        /*
         * Etape n°6 : Requêtage du SGBD sans SELECT !!
         * */

        int responseInt = -1;

        try {
            responseInt = stmt.executeUpdate(requeteSqlSansSelect);
            if (responseInt == 0 || responseInt == -1) System.out.println("L'ecriture de (" + requeteSqlSansSelect + ") n'a pas aboutit");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return responseInt;
    }

    public static ResultSet requeteLectureBase(Statement stmt, ResultSet rs, String requeteAvecSelect) {
        /*
         * Etape n°7 : Requêtage du SGBD avec SELECT :
         * */
        try {
            rs = stmt.executeQuery(requeteAvecSelect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public static void affichageResultatConsole(ResultSet rs) throws SQLException {
        System.out.println("\n" + "Resultat de la requête :" + "\n");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            if (i == 1) System.out.print("|");
            System.out.print(metaData.getColumnName(i));
            System.out.print("(" + metaData.getColumnTypeName(i) + ")|");
            if (i == columnCount) System.out.print("\n");
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            for (int i = 1; i <= columnCount; i++) {

                if (metaData.getColumnTypeName(i).equals("DATETIME")) {
                    // on peut donner l'index i ou le nom de la colonne "date"
                    Timestamp timestamp = rs.getTimestamp("date");
                    System.out.print(" " + timestamp);
                } else {
                    System.out.print(" " + rs.getString(i));
                }

            }
            System.out.print("\n");
        }
    }


    public static void libererConnexion(Connection maConnection, Statement stmt) {
        /*
         * ~8ième Etape : Libération des ressources (important, ne pas oublier pour préserver le réseau, ressources mémoires etc ...)
         * */
        try {
            stmt.close();
            maConnection.close();

            if (debug) System.out.println("\n".repeat(2) + "==".repeat(1) + "FIN" + "==".repeat(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void importSQL(Connection conn, InputStream in) throws SQLException
    { 
        Scanner s = new Scanner(in);
        s.useDelimiter("(;(\r)?\n)|(--\n)");
        Statement st = null;
        try
        { 
            st = conn.createStatement();
            while (s.hasNext())
            { 
                String line = s.next();
                if (line.startsWith("/*!") && line.endsWith("*/"))
                { 
                    int i = line.indexOf(' ');
                    line = line.substring(i + 1, line.length() - " */".length());
                } 

                if (line.trim().length() > 0)
                { 
                    st.execute(line);
                } 
            } 
        } 
    finally
        { 
            if (st != null) st.close();
        } 
    }

    public static void executeScript(Connection maConnection, String cheminVersLeFichier) {
        File monFichier = new File(cheminVersLeFichier);
        try {
            importSQL(maConnection, new FileInputStream(monFichier));
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de l'execution du script (" + cheminVersLeFichier + ").");
            e.printStackTrace();
        }
    }

}
