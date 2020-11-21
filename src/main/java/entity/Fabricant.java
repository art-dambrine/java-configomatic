package entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class Fabricant {
    private int id;
    private String nom;

    public Fabricant(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Fabricant(Fabricant fabricant){
        this.id = fabricant.id;
        this.nom = fabricant.nom;
    }

    @Override
    public String toString() {
        return "Fabricant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }


    public static List<Fabricant> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM fabricant");

        List<Fabricant> mesFabricants = new ArrayList<>();
        while (rs.next())
            mesFabricants.add(new Fabricant(rs.getInt("id"), rs.getString("nom")));

        libererConnexion(maConnection, stmt);
        return mesFabricants;
    }



    public static Fabricant findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt, "SELECT * FROM fabricant WHERE id=" + id);

        rs.next();
        Fabricant monFabricant = new Fabricant(rs.getInt("id"), rs.getString("nom"));

        libererConnexion(maConnection, stmt);
        return monFabricant;
    }
}
