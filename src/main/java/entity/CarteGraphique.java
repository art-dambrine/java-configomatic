package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class CarteGraphique {
    private int id;
    private String nom;
    private float prix;
    private int memoireGraphique;
    private float puissanceTflops;
    private Fabricant fabricant;

    public CarteGraphique(
            int id, String nom, float prix, int memoireGraphique, float puissanceTflops, Fabricant fabricant) {

        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.memoireGraphique = memoireGraphique;
        this.puissanceTflops = puissanceTflops;
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "CarteGraphique{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", memoireGraphique=" + memoireGraphique +
                ", puissanceTflops=" + puissanceTflops +
                ", fabricant=" + fabricant +
                '}';
    }

    public static List<CarteGraphique> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT carte_graphique.id as 'id',\n" +
                        "       carte_graphique.nom,\n" +
                        "       carte_graphique.prix,\n" +
                        "       carte_graphique.memoire_graphique_go,\n" +
                        "       carte_graphique.puissance_tflops,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM carte_graphique,\n" +
                        "     fabricant\n" +
                        "WHERE carte_graphique.fabricant = fabricant.id\n");

        List<CarteGraphique> mesCarteGraphiques = new ArrayList<>();
        while (rs.next())
            mesCarteGraphiques.add(new CarteGraphique(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getInt("memoire_graphique_go"),
                    rs.getFloat("puissance_tflops"),
                    new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
            ));


        libererConnexion(maConnection, stmt);
        return mesCarteGraphiques;
    }

    public static CarteGraphique findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT carte_graphique.id as 'id',\n" +
                        "       carte_graphique.nom,\n" +
                        "       carte_graphique.prix,\n" +
                        "       carte_graphique.memoire_graphique_go,\n" +
                        "       carte_graphique.puissance_tflops,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM carte_graphique,\n" +
                        "     fabricant\n" +
                        "WHERE\n" +
                        "      carte_graphique.id = " + id + "\n" +
                        "      AND carte_graphique.fabricant = fabricant.id\n");

        rs.next();
        CarteGraphique maCarteGraphique = new CarteGraphique(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("memoire_graphique_go"),
                rs.getFloat("puissance_tflops"),
                new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
        );

        libererConnexion(maConnection, stmt);
        return maCarteGraphique;
    }
}
