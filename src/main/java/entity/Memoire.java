package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class Memoire {

    private int id;
    private String nom;
    private float prix;
    private int capaciteGo;
    private String type;
    private Fabricant fabricant;

    public Memoire(int id, String nom, float prix, int capaciteGo, String type, Fabricant fabricant) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.capaciteGo = capaciteGo;
        this.type = type;
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "Memoire{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", capaciteGo=" + capaciteGo +
                ", type='" + type + '\'' +
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

    public int getCapaciteGo() {
        return capaciteGo;
    }

    public void setCapaciteGo(int capaciteGo) {
        this.capaciteGo = capaciteGo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    public static List<Memoire> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT memoire.id as 'id',\n" +
                        "       memoire.nom,\n" +
                        "       memoire.prix,\n" +
                        "       memoire.capacite_go,\n" +
                        "       memoire.type,\n" +
                        "       fabricant.id  as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM memoire,\n" +
                        "     fabricant\n" +
                        "WHERE memoire.fabricant = fabricant.id");

        List<Memoire> mesMemoires = new ArrayList<>();
        while (rs.next())
            mesMemoires.add(new Memoire(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getInt("capacite_go"),
                    rs.getString("type"),
                    new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
            ));


        libererConnexion(maConnection, stmt);
        return mesMemoires;
    }

    public static Memoire findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT memoire.id as 'id',\n" +
                        "       memoire.nom,\n" +
                        "       memoire.prix,\n" +
                        "       memoire.capacite_go,\n" +
                        "       memoire.type,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM memoire,\n" +
                        "     fabricant\n" +
                        "WHERE\n" +
                        "        memoire.id = " + id + "\n" +
                        "  AND memoire.fabricant = fabricant.id");

        rs.next();
        Memoire maMemoire = new Memoire(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("capacite_go"),
                rs.getString("type"),
                new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
        );

        libererConnexion(maConnection, stmt);
        return maMemoire;
    }

}
