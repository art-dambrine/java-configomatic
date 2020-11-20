package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static dbtools.Dbtools.*;

public class Processeur implements Readable {

    private int id;
    private String nom;
    private float prix;
    private int nombreCoeurs;
    private Fabricant fabricant;

    public Processeur() {
    }

    public Processeur(int id, String nom, float prix, int nombreCoeurs, Fabricant fabricant) {
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

    @Override
    public List<Readable> fecthAll() throws SQLException {
        return null;
    }

    @Override
    public Readable findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM processeur WHERE id=" + id);

        rs.next();

        Readable fabricant = new Fabricant();
        fabricant = fabricant.findOne(rs.getInt("fabricant"));

        Processeur processeur = new Processeur(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("nombre_coeurs"),
                (Fabricant) fabricant
        );

        libererConnexion(maConnection, stmt);
        return processeur;
    }
}
