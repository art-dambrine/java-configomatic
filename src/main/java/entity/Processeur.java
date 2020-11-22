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
    private Fabricant fabricant;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNombreCoeurs() {
        return nombreCoeurs;
    }

    public void setNombreCoeurs(int nombreCoeurs) {
        this.nombreCoeurs = nombreCoeurs;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    public static List<Processeur> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT processeur.id as 'id',\n" +
                        "       processeur.nom,\n" +
                        "       processeur.prix,\n" +
                        "       processeur.nombre_coeurs,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM processeur,\n" +
                        "     fabricant\n" +
                        "WHERE processeur.fabricant = fabricant.id\n");

        List<Processeur> mesProcesseurs = new ArrayList<>();
        while (rs.next())
            mesProcesseurs.add(new Processeur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getInt("nombre_coeurs"),
                    new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
            ));

        libererConnexion(maConnection, stmt);
        return mesProcesseurs;
    }


    public static Processeur findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT processeur.id as 'id',\n" +
                        "       processeur.nom,\n" +
                        "       processeur.prix,\n" +
                        "       processeur.nombre_coeurs,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM processeur,\n" +
                        "     fabricant\n" +
                        "WHERE processeur.id = " + id + " AND processeur.fabricant = fabricant.id\n");

        rs.next();
        Processeur processeur = new Processeur(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("nombre_coeurs"),
                new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
        );

        libererConnexion(maConnection, stmt);
        return processeur;
    }
}
