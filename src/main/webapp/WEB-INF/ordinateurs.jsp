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
        <h2>Ici consultez la liste des PC créés par la communauté</h2> <br>
        <% // Importation de ma liste des ordinateurs :
            List<Ordinateur> ordinateurs = (List<Ordinateur>) request.getAttribute("ordinateurs");
        %>

        <c:forEach items="${ordinateurs}" var="ordinateur">
            <div class="jumbotron jumbotron-fluid table-ordinateur">
                <div class="container">

                    <!-- Tableau ordinateur -->
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Ordinateur n°${ordinateur.id}</th>
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
                                    <tr>
                                        <td>Processeur</td>
                                        <td class="text-center"><a
                                                style="color: #306996">${ordinateur.processeur.fabricant.nom} ${ordinateur.processeur.nom}</a>
                                        </td>
                                        <td class="text-center">${ordinateur.processeur.prix}€</td>
                                    </tr>
                                    <tr>
                                        <td>Carte Mère</td>
                                        <td class="text-center"><a style="color: #306996">${ordinateur.carteMere.fabricant.nom}</a></td>
                                        <td class="text-center">${ordinateur.carteMere.prix}€</td>
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
                                        <button class="btn btn-sm btn-danger">Supprimer la config</button>
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


<%@ include file="inclusionfooter.jsp" %>
</body>
</html>
