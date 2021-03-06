<%@ page import="java.util.List" %>
<%@ page import="javax.swing.*" %>
<%@ page import="entity.*" %><%--
  Created by IntelliJ IDEA.
  User: arthurdambrine
  Date: 21/11/2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="inclusionheader.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="content-container">
    <div class="centered-container">
        <h2>Configurez le PC de vos rêves</h2> <br>

        <% // Importation des listes de composants :
            List<Processeur> processeurs = (List<Processeur>) request.getAttribute("processeurs");
            List<CarteMere> cartemeres = (List<CarteMere>) request.getAttribute("cartemeres");
            List<Memoire> memoires = (List<Memoire>) request.getAttribute("memoires");
            List<CarteGraphique> cartegraphiques = (List<CarteGraphique>) request.getAttribute("cartegraphiques");
            List<DisqueDur> disquedurs = (List<DisqueDur>) request.getAttribute("disquedurs");
        %>

        <form id="myForm">

            <%--Processeur--%>
            <div class="form-group">
                <label for="inputProcesseur">Processeur</label>
                <select required class="form-control" id="inputProcesseur" name="inputProcesseur" onchange="if (this.selectedIndex) calcMontant();">
                    <option value="" disabled selected>Selectionnez un processeur...</option>
                    <% for (Processeur processeur : processeurs) {
                        out.print(
                                "<option value=\"" + processeur.getId() + "\"" +
                                        "data-price=\"" + processeur.getPrix() + "\">" +
                                        processeur.getFabricant().getNom() +
                                        " " + processeur.getNom() +
                                        " - " + processeur.getNombreCoeurs() + " coeurs" +
                                        " - " + processeur.getPrix() + "€" +
                                        "</option>"
                        );
                    } %>
                </select>
                <small id="processeurHelp" class="form-text text-muted">Le processeur est le cerveau de votre
                    ordinateur.</small>
            </div>

            <%--Carte mère--%>
            <div class="form-group">
                <label for="inputCarteMere">Carte mère</label>
                <select required class="form-control" id="inputCarteMere" name="inputCarteMere" onchange="if (this.selectedIndex) calcMontant();">
                    <option value="" disabled selected>Selectionnez une carte mère...</option>
                    <% for (CarteMere carteMere : cartemeres) {
                        out.print(
                                "<option value=\"" + carteMere.getId() + "\"" +
                                        "data-price=\"" + carteMere.getPrix() + "\">" +
                                        carteMere.getFabricant().getNom() +
                                        " " + carteMere.getNom()
                        );
                        if (carteMere.getCompatibiliteUSBC()) out.print(" - USBC");
                        if (carteMere.getPortPciExpress()) out.print(" - PCI Express");
                        out.print(
                                " - " + carteMere.getPrix() + "€" +
                                        "</option>"
                        );
                    } %>
                </select>
                <small id="carteMereHelp" class="form-text text-muted">La carte mère est la base de votre build.</small>
            </div>

            <%--Memoire RAM--%>
            <div class="form-group">
                <label for="inputMemoire">RAM</label>
                <select required class="form-control" id="inputMemoire" name="inputMemoire" onchange="if (this.selectedIndex) calcMontant();">
                    <option value="" disabled selected>Selectionnez la RAM...</option>
                    <% for (Memoire memoire : memoires) {
                        out.print(
                                "<option value=\"" + memoire.getId() + "\"" +
                                        "data-price=\"" + memoire.getPrix() + "\">" +
                                        memoire.getFabricant().getNom() +
                                        " " + memoire.getNom() +
                                        " - " + memoire.getCapaciteGo() + " GO" +
                                        " - " + memoire.getType() +
                                        " - " + memoire.getPrix() + "€" +
                                        "</option>"
                        );
                    } %>
                </select>
                <small id="memoireHelp" class="form-text text-muted">Sans la RAM votre ordinateur ne pourra même pas
                    compter sur ses doigts.</small>
            </div>

            <%--Carte Graphique--%>
            <div class="form-group">
                <label for="inputCarteGraphique">Carte graphique</label>
                <select required class="form-control" id="inputCarteGraphique" name="inputCarteGraphique" onchange="if (this.selectedIndex) calcMontant();">
                    <option value="" disabled selected>Selectionnez une carte graphique...</option>
                    <% for (CarteGraphique carteGraphique : cartegraphiques) {
                        out.print(
                                "<option value=\"" + carteGraphique.getId() + "\"" +
                                        "data-price=\"" + carteGraphique.getPrix() + "\">" +
                                        carteGraphique.getFabricant().getNom() +
                                        " " + carteGraphique.getNom() +
                                        " - " + carteGraphique.getMemoireGraphique() + " GO" +
                                        " - " + carteGraphique.getPuissanceTflops() + " TFLOPS" +
                                        " - " + carteGraphique.getPrix() + "€" +
                                        "</option>"
                        );
                    } %>
                </select>
                <small id="carteGraphiqueHelp" class="form-text text-muted">Sans carte graphique on ira pas plus loin
                    que pong.</small>
            </div>

            <%--Disque dur--%>

            <div class="form-group">
                <label for="inputDisqueDur">Disque dur</label>
                <select required class="form-control" id="inputDisqueDur" name="inputDisqueDur" onchange="if (this.selectedIndex) calcMontant();">
                    <option value="" disabled selected>Selectionnez un disque dur...</option>
                    <% for (DisqueDur disqueDur : disquedurs) {
                        out.print(
                                "<option value=\"" + disqueDur.getId() + "\"" +
                                        "data-price=\"" + disqueDur.getPrix() + "\">" +
                                        disqueDur.getFabricant().getNom() +
                                        " " + disqueDur.getNom() +
                                        " - " + disqueDur.getCapaciteGo() + " GO" +
                                        " - " + disqueDur.getPrix() + "€" +
                                        "</option>"
                        );
                    } %>
                </select>
                <small id="disqueDurHelp" class="form-text text-muted">Oui c'est bien là que va votre collection de jeux
                    Steam.</small>
            </div>

            <p>Montant total : <span id="montant-total">0</span> €</p>
            <button type="submit" class="btn btn-primary" id="button-submit">Enregistrer ma config</button>
            <span class="text-danger pl-2" id="invalid-feedback"></span>

        </form>


    </div>

</div>

<script src="js/calculmontant.js"></script>
<script src="js/postordinateur.js"></script>
<%@ include file="inclusionfooter.jsp" %>
</body>
</html>
