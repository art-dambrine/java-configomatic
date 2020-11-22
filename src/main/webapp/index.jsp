<%--
  Created by IntelliJ IDEA.
  User: arthurdambrine
  Date: 21/11/2020
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="WEB-INF/inclusionheader.jsp" %>
</head>
<body>

<%@ include file="WEB-INF/navbar.jsp" %>

<div class="content-container">

    <div class="centered-container">
        <h2>Bienvenue dans l'application ConfigoMatic</h2> <br>

        <h1 id="projet-java-ee-configomatic">Projet Java EE - Configomatic</h1>
        <h2 id="introduction-sujet">Introduction - sujet</h2>
        <p>Le sujet est libre, la seule contrainte est de créer une application basée entièrement sur la technologie
            Java EE (Backend et Frontend doivent être développés dans une seule application) cette application doit
            interagir permettre l’interaction avec l’utilisateur sous forme d’une application web et permettre la mise à
            jour des informations sur une base de données. Nous privilégierons pour ce projet une approche MVC.</p>
        <p>Nous allons séparer :</p>
        <ul>
            <li>le code de gestion de nos entités d’une une part (<strong>model</strong>)</li>
            <li>les servlets (<strong>controler</strong>)</li>
            <li>les pages JSP (<strong>view</strong>)</li>
        </ul>
        <p>Nous avons fait le choix de créer une application de montage de PC de bureau custom (entendez par là une
            config gaming !).</p>
        <h2 id="premi-re-s-ance-20-11-2020-">Première séance (20-11-2020)</h2>
        <ul>
            <li>Mise en place de la base de donnée</li>
            <li>Création de fixtures (pour remplir la base de données avec les composants et fabricants)</li>
            <li>Mise en place des premiers objets de manipulation de ces données</li>
        </ul>
        <p>Schéma de notre base de donnée :</p>
        <p><img class="w-100" src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/dbdiagram.png"
                alt="dbdiagram"></p>
        <p>Bonus : rédaction des tests unitaires (test de lecture des composants et fabricants)</p>
        <p><img class="w-100" src="https://github.com/art-dambrine/java-configomatic/blob/master/img/first-test-junit.png?raw=true"
                alt="first-test-junit"></p>
        <h2 id="deuxi-me-s-ance-24-11-2020-">Deuxième séance (24-11-2020)</h2>
        <ul>
            <li>Mise en place des deux servelets de base (/ordinateurs, /config)</li>
            <li>Design minimal de la webapp</li>
            <li>Formulaire de config d&#39;un ordinateur</li>
        </ul>
        <p><img class="w-100" src="https://github.com/art-dambrine/java-configomatic/blob/master/img/draft-config.png?raw=true"
                alt="draft-config"></p>

    </div>


</div>


<%@ include file="WEB-INF/inclusionfooter.jsp" %>
</body>
</html>
