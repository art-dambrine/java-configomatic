package entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dbtools.Dbtools.*;

public class Ordinateur {
    private int id;
    private Processeur processeur;
    private CarteMere carteMere;
    private Memoire memoire;
    private CarteGraphique carteGraphique;
    private DisqueDur disqueDur;
    private float prix;
    private boolean vendu;
    private Timestamp datetimeCreation;
    private Timestamp datetimeVendu;

    public Ordinateur(int id, Processeur processeur, CarteMere carteMere, Memoire memoire, CarteGraphique carteGraphique, DisqueDur disqueDur, float prix, boolean vendu, Timestamp datetimeCreation, Timestamp datetimeVendu) {
        this.id = id;
        this.processeur = processeur;
        this.carteMere = carteMere;
        this.memoire = memoire;
        this.carteGraphique = carteGraphique;
        this.disqueDur = disqueDur;
        this.prix = prix;
        this.vendu = vendu;
        this.datetimeCreation = datetimeCreation;
        this.datetimeVendu = datetimeVendu;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "id=" + id +
                ", processeur=" + processeur +
                ", carteMere=" + carteMere +
                ", memoire=" + memoire +
                ", carteGraphique=" + carteGraphique +
                ", disqueDur=" + disqueDur +
                ", prix=" + prix +
                ", vendu=" + vendu +
                ", datetimeCreation=" + datetimeCreation +
                ", datetimeVendu=" + datetimeVendu +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Processeur getProcesseur() {
        return processeur;
    }

    public void setProcesseur(Processeur processeur) {
        this.processeur = processeur;
    }

    public CarteMere getCarteMere() {
        return carteMere;
    }

    public void setCarteMere(CarteMere carteMere) {
        this.carteMere = carteMere;
    }

    public Memoire getMemoire() {
        return memoire;
    }

    public void setMemoire(Memoire memoire) {
        this.memoire = memoire;
    }

    public CarteGraphique getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(CarteGraphique carteGraphique) {
        this.carteGraphique = carteGraphique;
    }

    public DisqueDur getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(DisqueDur disqueDur) {
        this.disqueDur = disqueDur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isVendu() {
        return vendu;
    }

    public void setVendu(boolean vendu) {
        this.vendu = vendu;
    }

    public Timestamp getDatetimeCreation() {
        return datetimeCreation;
    }

    public void setDatetimeCreation(Timestamp datetimeCreation) {
        this.datetimeCreation = datetimeCreation;
    }

    public Timestamp getDatetimeVendu() {
        return datetimeVendu;
    }

    public void setDatetimeVendu(Timestamp datetimeVendu) {
        this.datetimeVendu = datetimeVendu;
    }


    public static int createOne(Ordinateur ordinateur) throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        int resultCode = requeteEcritureBase(stmt,
                "INSERT INTO ordinateur(processeur, carte_mere, memoire, carte_graphique, disque_dur, prix, datetime_creation)\n" +
                        "VALUES (" + ordinateur.processeur.getId() + ", \n" +
                        "        " + ordinateur.carteMere.getId() + ", \n" +
                        "        " + ordinateur.memoire.getId() + ", \n" +
                        "        " + ordinateur.carteGraphique.getId() + ", \n" +
                        "        " + ordinateur.disqueDur.getId() + ", \n" +
                        "        " + ordinateur.prix + ",\n" +
                        "        NOW())" +
                        "");

        libererConnexion(maConnection, stmt);
        return resultCode;
    }

    public static List<Ordinateur> fetchAll() throws SQLException {
        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);

        List<Ordinateur> mesOrdinateurs = new ArrayList<>();

        ResultSet rs = requeteLectureBase(stmt, "" +
                "SELECT\n" +
                "       ordinateur.id as 'ordinateur_id',\n" +
                "\n" +
                "       -- processeur\n" +
                "       p.id as 'processeur_id',\n" +
                "       p.nom as 'processeur_nom',\n" +
                "       p.prix as 'processeur_prix',\n" +
                "       p.nombre_coeurs as 'processeur_nombre_coeurs',\n" +
                "       p.fabricant as 'processeur_fabricant_id',\n" +
                "       (SELECT fabricant.nom from fabricant WHERE fabricant.id = p.fabricant) as 'processeur_fabricant_nom',\n" +
                "\n" +
                "       -- carte_mere\n" +
                "       cm.id as 'carte_mere_id',\n" +
                "       cm.nom as 'carte_mere_nom',\n" +
                "       cm.prix as 'carte_mere_prix',\n" +
                "       cm.compatibilite_usbc as 'carte_mere_compatibilite_usbc',\n" +
                "       cm.port_pci_express as 'carte_mere_port_pci_express',\n" +
                "       cm.fabricant as 'carte_mere_fabricant_id',\n" +
                "       (SELECT fabricant.nom from fabricant WHERE fabricant.id = cm.fabricant) as 'carte_mere_fabricant_nom',\n" +
                "\n" +
                "       -- memoire\n" +
                "       m.id as 'memoire_id',\n" +
                "       m.nom as 'memoire_nom',\n" +
                "       m.prix as 'memoire_prix',\n" +
                "       m.capacite_go as 'memoire_capacite_go',\n" +
                "       m.type as 'memoire_type',\n" +
                "       m.fabricant as 'memoire_fabricant_id',\n" +
                "       (SELECT fabricant.nom from fabricant WHERE fabricant.id = m.fabricant) as 'memoire_fabricant_nom',\n" +
                "\n" +
                "       -- carte_graphique\n" +
                "       cg.id as 'carte_graphique_id',\n" +
                "       cg.nom as 'carte_graphique_nom',\n" +
                "       cg.prix as 'carte_graphique_prix',\n" +
                "       cg.memoire_graphique_go as 'carte_graphique_memoire_graphique_go',\n" +
                "       cg.puissance_tflops as 'carte_graphique_puissance_tflops',\n" +
                "       cg.fabricant as 'carte_graphique_fabricant_id',\n" +
                "       (SELECT fabricant.nom from fabricant WHERE fabricant.id = cg.fabricant) as 'carte_graphique_fabricant_nom',\n" +
                "\n" +
                "       -- disque_dur\n" +
                "       dd.id as 'disque_dur_id',\n" +
                "       dd.nom as 'disque_dur_nom',\n" +
                "       dd.prix as 'disque_dur_prix',\n" +
                "       dd.capacite_go as 'disque_dur_capacite_go',\n" +
                "       dd.fabricant as 'disque_dur_fabricant_id',\n" +
                "       (SELECT fabricant.nom from fabricant WHERE fabricant.id = dd.fabricant) as 'disque_dur_fabricant_nom',\n" +
                "\n" +
                "       ordinateur.prix as 'ordinateur_prix',\n" +
                "       ordinateur.vendu as 'ordinateur_vendu',\n" +
                "       ordinateur.datetime_creation as 'ordinateur_datetime_creation',\n" +
                "       ordinateur.datetime_vendu as 'ordinateur_datetime_vendu'\n" +
                "\n" +
                "FROM ordinateur,\n" +
                "     processeur p,\n" +
                "     carte_mere cm,\n" +
                "     memoire m,\n" +
                "     carte_graphique cg,\n" +
                "     disque_dur dd\n" +
                "WHERE ordinateur.processeur = p.id\n" +
                "AND ordinateur.carte_mere = cm.id\n" +
                "AND ordinateur.memoire = m.id\n" +
                "AND ordinateur.carte_graphique = cg.id\n" +
                "AND ordinateur.disque_dur = dd.id");

        while (rs.next())
            mesOrdinateurs.add(new Ordinateur(
                    rs.getInt("ordinateur_id"),
                    new Processeur(rs.getInt("processeur_id"), rs.getString("processeur_nom"), rs.getFloat("processeur_prix"), rs.getInt("processeur_nombre_coeurs"), new Fabricant(rs.getInt("processeur_fabricant_id"), rs.getString("processeur_fabricant_nom"))),
                    new CarteMere(rs.getInt("carte_mere_id"), rs.getString("carte_mere_nom"), rs.getFloat("carte_mere_prix"), rs.getBoolean("carte_mere_compatibilite_usbc"), rs.getBoolean("carte_mere_port_pci_express"), new Fabricant(rs.getInt("carte_mere_fabricant_id"), rs.getString("carte_mere_fabricant_nom"))),
                    new Memoire(rs.getInt("memoire_id"), rs.getString("memoire_nom"), rs.getFloat("memoire_prix"), rs.getInt("memoire_capacite_go"), rs.getString("memoire_type"), new Fabricant(rs.getInt("memoire_fabricant_id"), rs.getString("memoire_fabricant_nom"))),
                    new CarteGraphique(rs.getInt("carte_graphique_id"), rs.getString("carte_graphique_nom"), rs.getFloat("carte_graphique_prix"), rs.getInt("carte_graphique_memoire_graphique_go"), rs.getFloat("carte_graphique_puissance_tflops"), new Fabricant(rs.getInt("carte_graphique_fabricant_id"), rs.getString("carte_graphique_fabricant_nom"))),
                    new DisqueDur(rs.getInt("disque_dur_id"), rs.getString("disque_dur_nom"), rs.getFloat("disque_dur_prix"), rs.getInt("disque_dur_capacite_go"), new Fabricant(rs.getInt("disque_dur_fabricant_id"), rs.getString("disque_dur_fabricant_nom"))),
                    rs.getFloat("ordinateur_prix"),
                    rs.getBoolean("ordinateur_vendu"),
                    rs.getTimestamp("ordinateur_datetime_creation"),
                    rs.getTimestamp("ordinateur_datetime_vendu")
            ));

        libererConnexion(maConnection, stmt);
        return mesOrdinateurs;
    }

    public static Ordinateur findOne(int id) throws SQLException {

        Connection maConnection = getConnexion();
        Statement stmt = getStatement(maConnection);
        Ordinateur monOrdinateur = null;

        ResultSet rs = requeteLectureBase(stmt, "" +
                "SELECT\n" +
                "    ordinateur.id as 'ordinateur_id',\n" +
                "\n" +
                "    -- processeur\n" +
                "    p.id as 'processeur_id',\n" +
                "    p.nom as 'processeur_nom',\n" +
                "    p.prix as 'processeur_prix',\n" +
                "    p.nombre_coeurs as 'processeur_nombre_coeurs',\n" +
                "    p.fabricant as 'processeur_fabricant_id',\n" +
                "    (SELECT fabricant.nom from fabricant WHERE fabricant.id = p.fabricant) as 'processeur_fabricant_nom',\n" +
                "\n" +
                "    -- carte_mere\n" +
                "    cm.id as 'carte_mere_id',\n" +
                "    cm.nom as 'carte_mere_nom',\n" +
                "    cm.prix as 'carte_mere_prix',\n" +
                "    cm.compatibilite_usbc as 'carte_mere_compatibilite_usbc',\n" +
                "    cm.port_pci_express as 'carte_mere_port_pci_express',\n" +
                "    cm.fabricant as 'carte_mere_fabricant_id',\n" +
                "    (SELECT fabricant.nom from fabricant WHERE fabricant.id = cm.fabricant) as 'carte_mere_fabricant_nom',\n" +
                "\n" +
                "    -- memoire\n" +
                "    m.id as 'memoire_id',\n" +
                "    m.nom as 'memoire_nom',\n" +
                "    m.prix as 'memoire_prix',\n" +
                "    m.capacite_go as 'memoire_capacite_go',\n" +
                "    m.type as 'memoire_type',\n" +
                "    m.fabricant as 'memoire_fabricant_id',\n" +
                "    (SELECT fabricant.nom from fabricant WHERE fabricant.id = m.fabricant) as 'memoire_fabricant_nom',\n" +
                "\n" +
                "    -- carte_graphique\n" +
                "    cg.id as 'carte_graphique_id',\n" +
                "    cg.nom as 'carte_graphique_nom',\n" +
                "    cg.prix as 'carte_graphique_prix',\n" +
                "    cg.memoire_graphique_go as 'carte_graphique_memoire_graphique_go',\n" +
                "    cg.puissance_tflops as 'carte_graphique_puissance_tflops',\n" +
                "    cg.fabricant as 'carte_graphique_fabricant_id',\n" +
                "    (SELECT fabricant.nom from fabricant WHERE fabricant.id = cg.fabricant) as 'carte_graphique_fabricant_nom',\n" +
                "\n" +
                "    -- disque_dur\n" +
                "    dd.id as 'disque_dur_id',\n" +
                "    dd.nom as 'disque_dur_nom',\n" +
                "    dd.prix as 'disque_dur_prix',\n" +
                "    dd.capacite_go as 'disque_dur_capacite_go',\n" +
                "    dd.fabricant as 'disque_dur_fabricant_id',\n" +
                "    (SELECT fabricant.nom from fabricant WHERE fabricant.id = dd.fabricant) as 'disque_dur_fabricant_nom',\n" +
                "\n" +
                "    ordinateur.prix as 'ordinateur_prix',\n" +
                "    ordinateur.vendu as 'ordinateur_vendu',\n" +
                "    ordinateur.datetime_creation as 'ordinateur_datetime_creation',\n" +
                "    ordinateur.datetime_vendu as 'ordinateur_datetime_vendu'\n" +
                "\n" +
                "FROM ordinateur,\n" +
                "     processeur p,\n" +
                "     carte_mere cm,\n" +
                "     memoire m,\n" +
                "     carte_graphique cg,\n" +
                "     disque_dur dd\n" +
                "WHERE ordinateur.processeur = p.id\n" +
                "  AND ordinateur.carte_mere = cm.id\n" +
                "  AND ordinateur.memoire = m.id\n" +
                "  AND ordinateur.carte_graphique = cg.id\n" +
                "  AND ordinateur.disque_dur = dd.id\n" +
                " AND ordinateur.id =" + id);

        rs.next();
        monOrdinateur = new Ordinateur(
                rs.getInt("ordinateur_id"),
                new Processeur(rs.getInt("processeur_id"), rs.getString("processeur_nom"), rs.getFloat("processeur_prix"), rs.getInt("processeur_nombre_coeurs"), new Fabricant(rs.getInt("processeur_fabricant_id"), rs.getString("processeur_fabricant_nom"))),
                new CarteMere(rs.getInt("carte_mere_id"), rs.getString("carte_mere_nom"), rs.getFloat("carte_mere_prix"), rs.getBoolean("carte_mere_compatibilite_usbc"), rs.getBoolean("carte_mere_port_pci_express"), new Fabricant(rs.getInt("carte_mere_fabricant_id"), rs.getString("carte_mere_fabricant_nom"))),
                new Memoire(rs.getInt("memoire_id"), rs.getString("memoire_nom"), rs.getFloat("memoire_prix"), rs.getInt("memoire_capacite_go"), rs.getString("memoire_type"), new Fabricant(rs.getInt("memoire_fabricant_id"), rs.getString("memoire_fabricant_nom"))),
                new CarteGraphique(rs.getInt("carte_graphique_id"), rs.getString("carte_graphique_nom"), rs.getFloat("carte_graphique_prix"), rs.getInt("carte_graphique_memoire_graphique_go"), rs.getFloat("carte_graphique_puissance_tflops"), new Fabricant(rs.getInt("carte_graphique_fabricant_id"), rs.getString("carte_graphique_fabricant_nom"))),
                new DisqueDur(rs.getInt("disque_dur_id"), rs.getString("disque_dur_nom"), rs.getFloat("disque_dur_prix"), rs.getInt("disque_dur_capacite_go"), new Fabricant(rs.getInt("disque_dur_fabricant_id"), rs.getString("disque_dur_fabricant_nom"))),
                rs.getFloat("ordinateur_prix"),
                rs.getBoolean("ordinateur_vendu"),
                rs.getTimestamp("ordinateur_datetime_creation"),
                rs.getTimestamp("ordinateur_datetime_vendu")
        );

        libererConnexion(maConnection, stmt);
        return monOrdinateur;
    }

}
