package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class DisqueDur {

    private int id;
    private String nom;
    private float prix;
    private int capaciteGo;
    private Fabricant fabricant;

    public DisqueDur(int id, String nom, float prix, int capaciteGo, Fabricant fabricant) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.capaciteGo = capaciteGo;
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "DisqueDur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", capaciteGo=" + capaciteGo +
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

    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    public static List<DisqueDur> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT disque_dur.id as 'id',\n" +
                        "       disque_dur.nom,\n" +
                        "       disque_dur.prix,\n" +
                        "       disque_dur.capacite_go,\n" +
                        "       fabricant.id  as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM disque_dur,\n" +
                        "     fabricant\n" +
                        "WHERE disque_dur.fabricant = fabricant.id");

        List<DisqueDur> mesDisqueDurs = new ArrayList<>();
        while (rs.next())
            mesDisqueDurs.add(new DisqueDur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getInt("capacite_go"),
                    new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
            ));


        libererConnexion(maConnection, stmt);
        return mesDisqueDurs;
    }

    public static DisqueDur findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT disque_dur.id as 'id',\n" +
                        "       disque_dur.nom,\n" +
                        "       disque_dur.prix,\n" +
                        "       disque_dur.capacite_go,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM disque_dur,\n" +
                        "     fabricant\n" +
                        "WHERE\n" +
                        "        disque_dur.id = " + id + "\n" +
                        "  AND disque_dur.fabricant = fabricant.id");

        rs.next();
        DisqueDur monDisqueDur = new DisqueDur(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getInt("capacite_go"),
                new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
        );

        libererConnexion(maConnection, stmt);
        return monDisqueDur;
    }
}
