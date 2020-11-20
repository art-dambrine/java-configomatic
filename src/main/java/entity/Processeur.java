package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class Processeur {

    private int id;
    private String nom;
    private float prix;
    private int nombreCoeurs;
    private int fabricant;


    public Processeur(int id, String nom, float prix, int nombreCoeurs, int fabricant) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.nombreCoeurs = nombreCoeurs;
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "Processeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nombreCoeurs=" + nombreCoeurs +
                ", fabricant=" + fabricant +
                '}';
    }


    public static List<Processeur> fecthAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM processeur");

        List<Processeur> mesProcesseurs = new ArrayList<>();
        while (rs.next())
            mesProcesseurs.add(new Processeur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getInt("nombre_coeurs"),
                    rs.getInt("fabricant")
            ));

        libererConnexion(maConnection, stmt);
        return mesProcesseurs;
    }


    public static Processeur findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM processeur WHERE id=" + id);

        rs.next();
        Processeur processeur = new Processeur(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("nombre_coeurs"),
                rs.getInt("fabricant")
        );

        libererConnexion(maConnection, stmt);
        return processeur;
    }
}
