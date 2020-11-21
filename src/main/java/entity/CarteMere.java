package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class CarteMere {

    private int id;
    private String nom;
    private float prix;
    private Boolean compatibiliteUSBC;
    private Boolean portPciExpress;
    private Fabricant fabricant;


    public CarteMere(
            int id, String nom, float prix, Boolean compatibiliteUSBC, Boolean portPciExpress, Fabricant fabricant) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.compatibiliteUSBC = compatibiliteUSBC;
        this.portPciExpress = portPciExpress;
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return "CarteMere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", compatibiliteUSBC=" + compatibiliteUSBC +
                ", portPciExpress=" + portPciExpress +
                ", fabricant=" + fabricant +
                '}';
    }

    public static List<CarteMere> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT carte_mere.id as 'id',\n" +
                        "       carte_mere.nom,\n" +
                        "       carte_mere.prix,\n" +
                        "       carte_mere.compatibilite_usbc,\n" +
                        "       carte_mere.port_pci_express,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM carte_mere,\n" +
                        "     fabricant\n" +
                        "WHERE\n" +
                        "      carte_mere.fabricant = fabricant.id\n");

        List<CarteMere> mesCarteMeres = new ArrayList<>();
        while (rs.next())
            mesCarteMeres.add(new CarteMere(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getFloat("prix"),
                    rs.getBoolean("compatibilite_usbc"),
                    rs.getBoolean("port_pci_express"),
                    new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
            ));


        libererConnexion(maConnection, stmt);
        return mesCarteMeres;
    }

    public static CarteMere findOne(int id) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        ResultSet rs = requeteLectureBase(stmt,
                "SELECT carte_mere.id as 'id',\n" +
                        "       carte_mere.nom,\n" +
                        "       carte_mere.prix,\n" +
                        "       carte_mere.compatibilite_usbc,\n" +
                        "       carte_mere.port_pci_express,\n" +
                        "       fabricant.id as 'fabricant_id',\n" +
                        "       fabricant.nom as 'fabricant_nom'\n" +
                        "FROM carte_mere,\n" +
                        "     fabricant\n" +
                        "WHERE\n" +
                        "      carte_mere.id = " + id + "\n" +
                        "      AND carte_mere.fabricant = fabricant.id");

        rs.next();
        CarteMere maCarteMere = new CarteMere(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getFloat("prix"),
                rs.getBoolean("compatibilite_usbc"),
                rs.getBoolean("port_pci_express"),
                new Fabricant(rs.getInt("fabricant_id"), rs.getString("fabricant_nom"))
        );

        libererConnexion(maConnection, stmt);
        return maCarteMere;
    }
}
