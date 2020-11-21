<%--
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

        <form action="config" method="POST">

            <%--Processeur--%>
            <div class="form-group">
                <label for="inputProcesseur">Processeur</label>
                <select required class="form-control" id="inputProcesseur">
                    <option value="" disabled selected>Selectionnez un processeur...</option>
                    <option value="0">-</option>
                    <option value="1">-</option>
                </select>
                <small id="processeurHelp" class="form-text text-muted">Le processeur est le cerveau de votre ordinateur.</small>
            </div>

            <%--Carte mère--%>
            <div class="form-group">
                <label for="inputCarteMere">Carte mère</label>
                <select required class="form-control" id="inputCarteMere">
                    <option value="" disabled selected>Selectionnez une carte mère...</option>
                    <option value="0">-</option>
                    <option value="1">-</option>
                </select>
                <small id="carteMereHelp" class="form-text text-muted">La carte mère est la base de votre build.</small>
            </div>

            <%--Memoire RAM--%>
            <div class="form-group">
                <label for="inputMemoire">RAM</label>
                <select required class="form-control" id="inputMemoire">
                    <option value="" disabled selected>Selectionnez la RAM...</option>
                    <option value="0">-</option>
                    <option value="1">-</option>
                </select>
                <small id="memoireHelp" class="form-text text-muted">Sans la RAM votre ordinateur ne pourra même pas compter sur ses doigts.</small>
            </div>

            <%--Carte Graphique--%>
            <div class="form-group">
                <label for="inputCarteGraphique">Carte graphique</label>
                <select required class="form-control" id="inputCarteGraphique">
                    <option value="" disabled selected>Selectionnez une carte graphique...</option>
                    <option value="0">-</option>
                    <option value="1">-</option>
                </select>
                <small id="carteGraphiqueHelp" class="form-text text-muted">Sans carte graphique on ira pas plus loin que pong.</small>
            </div>

            <%--Disque dur--%>

            <div class="form-group">
                <label for="inputDisqueDur">Disque dur</label>
                <select required class="form-control" id="inputDisqueDur">
                    <option value="" disabled selected>Selectionnez un disque dur...</option>
                    <option value="0">-</option>
                    <option value="1">-</option>
                </select>
                <small id="disqueDurHelp" class="form-text text-muted">Oui c'est bien là que va votre collection de jeux Steam.</small>
            </div>

            <button type="submit" class="btn btn-primary">Enregistrer ma config</button>
        </form>


    </div>

</div>


<%@ include file="inclusionfooter.jsp" %>
</body>
</html>
