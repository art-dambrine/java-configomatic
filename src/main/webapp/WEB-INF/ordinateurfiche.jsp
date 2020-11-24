<%@ page import="entity.Ordinateur" %>
<%@ page import="java.util.List" %><%--
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
        <% // Importation de ma liste des ordinateurs :
            List<Ordinateur> ordinateurs = (List<Ordinateur>) request.getAttribute("ordinateurs");
        %>

        <c:forEach items="${ordinateurs}" var="ordinateur">
            <h2>Fiche de l'ordinateur n°${ordinateur.id}</h2> <br>

            <div class="jumbotron jumbotron-fluid table-ordinateur">
                <div class="container">

                    <!-- Tableau ordinateur -->
                    <table class="table">
                        <thead>
                        <tr>
                                <%--<th>Ordinateur n°${ordinateur.id}</th>--%>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <td class="td-recap-composants">
                                <!-- Tableau recap composants -->
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Composants</th>
                                        <th class="text-center">Description</th>
                                        <th class="text-center">Prix</th>
                                    </tr>
                                    </thead>

                                    <tbody>

                                        <%--Processeur--%>
                                    <tr>
                                        <td>Processeur</td>
                                        <td class="text-center"><a
                                                style="color: #306996">${ordinateur.processeur.fabricant.nom} ${ordinateur.processeur.nom}
                                            - ${ordinateur.processeur.nombreCoeurs} coeurs</a>
                                        </td>
                                        <td class="text-center">${ordinateur.processeur.prix}€</td>
                                    </tr>

                                        <%--Carte mère--%>
                                    <tr>
                                        <td>Carte Mère</td>
                                        <td class="text-center">
                                            <a
                                                    style="color: #306996">${ordinateur.carteMere.fabricant.nom} ${ordinateur.carteMere.nom}
                                                <c:if test="${ ordinateur.carteMere.compatibiliteUSBC }">
                                                    - USBC
                                                </c:if>
                                                <c:if test="${ ordinateur.carteMere.portPciExpress }">
                                                    - PCI Express
                                                </c:if>
                                            </a>
                                        </td>
                                        <td class="text-center">${ordinateur.carteMere.prix}€</td>
                                    </tr>
                                        <%--Memoire--%>
                                    <tr>
                                        <td>Memoire</td>
                                        <td class="text-center">
                                            <a
                                                    style="color: #306996">${ordinateur.memoire.fabricant.nom} ${ordinateur.memoire.nom}
                                                - ${ordinateur.memoire.capaciteGo} Go - ${ordinateur.memoire.type}
                                            </a>
                                        </td>
                                        <td class="text-center">${ordinateur.memoire.prix}€</td>
                                    </tr>

                                        <%--Carte Graphique--%>
                                    <tr>
                                        <td>Carte Graphique</td>
                                        <td class="text-center">
                                            <a
                                                    style="color: #306996">${ordinateur.carteGraphique.fabricant.nom} ${ordinateur.carteGraphique.nom}
                                                - ${ordinateur.carteGraphique.memoireGraphique} Go
                                                - ${ordinateur.carteGraphique.puissanceTflops} TFLOPS
                                            </a>
                                        </td>
                                        <td class="text-center">${ordinateur.carteGraphique.prix}€</td>
                                    </tr>

                                        <%--Disque Dur--%>
                                    <tr>
                                        <td>Disque Dur</td>
                                        <td class="text-center">
                                            <a
                                                    style="color: #306996">${ordinateur.disqueDur.fabricant.nom} ${ordinateur.disqueDur.nom}
                                                - ${ordinateur.disqueDur.capaciteGo} Go
                                            </a>
                                        </td>
                                        <td class="text-center">${ordinateur.disqueDur.prix}€</td>
                                    </tr>
                                    </tbody>
                                </table>


                            </td>
                        </tr>

                        <tr>
                            <th class="th-other-end">
                                <div class="div-flex">
                                    <p>Prix total : <a style="color: #007bfe">${ordinateur.prix}€</a></p>
                                    <p>
                                        <button class="btn btn-sm btn-danger"
                                                onclick="handleDeleteOrdinateur(${ordinateur.id},true)">Supprimer la
                                            config
                                        </button>
                                    </p>
                                </div>
                            </th>
                        </tr>
                        </tbody>
                    </table>


                </div>
            </div>


        </c:forEach>

    </div>

</div>

<script src="<%= application.getContextPath() %>/js/handledelete.js"></script>
<%@ include file="inclusionfooter.jsp" %>
</body>
</html>
