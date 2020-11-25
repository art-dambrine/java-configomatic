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
        <p><img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/dbdiagram.png"
                alt="dbdiagram"></p>
        <p>Bonus : rédaction des tests unitaires (test de lecture des composants et fabricants)</p>
        <p><img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/first-test-junit.png"
                alt="first-test-junit"></p>
        <h2 id="deuxi-me-s-ance-24-11-2020-">Deuxième séance (24-11-2020)</h2>
        <ul>
            <li>Mise en place des deux servelets de base (/ordinateurs, /config)</li>
            <li>Design minimal de la webapp</li>
            <li>Création du formulaire config</li>
        </ul>
        <p><img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/draft-config.png"
                alt="draft-config"></p>
        <ul>
            <li>Enrichissement du formulaire config avec les composants enregistrés en base</li>
            <li>Calcul du montant total des composants en euros via une fonction JavaScript (calculmontant.js)</li>
            <li>Création d&#39;une requête ajax d&#39;envoi du formulaire (format application/json)</li>
            <li>Création d&#39;un servlet dédiée à la création d&#39;ordinateur (/postordinateur)</li>
        </ul>
        <p>Note : pour le moment on retourne le contenu du json tel quel</p>
        <p>
            <img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/post-ordinateur-json.png"
                 alt="post-ordinateur-json"></p>
        <ul>
            <li><p>Validation de la requête ajax par le serveur</p>
            </li>
            <li><p>Creation de la methode Ordinateur.createOne</p>
            </li>
            <li><p>Insertion d&#39;un ordinateur en base après la requête post en ajax</p>
            </li>
            <li><p>Affichage des erreur de la requête ajax si il y en a sinon on retourne &#39;201 created&#39;</p>
            </li>
        </ul>
        <ul>
            <li><p>Exemples d&#39;erreurs affichées à l&#39;utilisateur :</p>
                <ul>
                    <li>Si l&#39;utilisateur n&#39;a pas remplit tous les champs</li>
                </ul>
                <p>
                    <img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/erreur-formulaire-incomplet.png"
                         alt="erreur-formulaire-incomplet"></p>
                <ul>
                    <li>Si une erreur survient côté serveur on retourne un code 500
                        <ul>
                            <li>json {&quot;message&quot;:&quot;Une erreur est survenue dans la requête&quot;}</li>
                        </ul>
                    </li>
                </ul>
                <br>
                <p>
                    <img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/erreur-serveur.png"
                         alt="erreur-serveur"></p>
            </li>
        </ul>
        <br>
        <h2 id="troisi-me-s-ance-27-11-2020-">Troisième séance (27-11-2020)</h2>
        <ul>
            <li><p>Création de la methode Ordinateur.fetchAll (problème des requêtes imbriquées, résolu en faisant une
                grande requête SQL ( 12s d&#39;excution (avec augmentation linéaire du temps de d&#39;excution
                xordinateurs*5 requêtes ) avec 32 entitées vs 1s avec 32 entitées))</p>
                <p><img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/test-fetchall-ordinateurs-requetes-imbriquees.png"
                        alt="test-fetchall-ordinateurs-requetes-imbriquees"></p>
            </li>
        </ul>
        <p>Capture : Résultat du test avec requêtes imbriquées successives (32 etitées ordinateur = 12s)</p>
        <ul>
            <li><p>Création de la requête SQL d&#39;un seul bloc pour ordinateurs avec composants et fabricants
                imbriqués</p>
            </li>
            <li><p>Création de la vue liste des ordinateurs (/ordinateurs) et fiche individuelle ordinateur
                (/ordinateur/{id})</p>
            </li>
            <li><p>Création de la methode Ordinateur.deleteOne, et de la servlet (DeleteOrdinateur avec
                /deleteordinateur/{id})</p>
            </li>
            <li><p>Ajout des boutons de suppression d&#39;un ordinateur dans la liste des ordinateurs et la fiche
                individuelle ordinateur</p>
            </li>
        </ul>

        <h4>Captures</h4>
        <ul>
            <li>Liste des ordinateurs</li>
        </ul>
        <p>
            <img src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/redirection-liste-ordinateurs.png"
                 alt="redirection-liste-ordinateurs"></p>
        <ul>
            <li>Fiche d&#39;un ordinateur<img
                    src="https://raw.githubusercontent.com/art-dambrine/java-configomatic/master/img/fiche-ordinateur.png"
                    alt="fiche-ordinateur"></li>
        </ul>

    </div>


</div>


<%@ include file="WEB-INF/inclusionfooter.jsp" %>
</body>
</html>
