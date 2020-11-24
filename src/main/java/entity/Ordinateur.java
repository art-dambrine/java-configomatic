package entity;

import java.sql.*;

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

}
