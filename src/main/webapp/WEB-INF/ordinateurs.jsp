<%@ page import="entity.Ordinateur" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
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

        <h2>Consultez les configurations de la communauté</h2> <br>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>Id.</th>
                <th class="text-center">Aperçu config</th>
                <th class="text-center">Prix total</th>
                <th class="text-center">Date de creation</th>
                <th class="text-center">Actions</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${ordinateurs}" var="ordinateur">
                <tr>
                    <td>${ordinateur.id}.</td>
                    <td class="text-center"><a href="./ordinateur/${ordinateur.id}">${ordinateur.processeur.nom}
                        - ${ordinateur.carteGraphique.nom}
                        - ${ordinateur.memoire.fabricant.nom} ${ordinateur.memoire.capaciteGo} Go</a></td>
                    <td class="text-center">${ordinateur.prix}€</td>
                    <td class="text-center"><%
                        String oldstring = ((Ordinateur) (pageContext.findAttribute("ordinateur"))).getDatetimeCreation().toString();
                        LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
                        out.print(datetime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))); // 2011-01-18
                    %>
                    </td>
                    <td class="text-center buttons-actions">
                        <button class="btn btn-sm btn-primary"
                                onclick="window.location = './ordinateur/${ordinateur.id}'">Afficher
                        </button>
                        <button class="btn btn-sm btn-danger" onclick="handleDeleteOrdinateur(${ordinateur.id})">Supprimer</button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </div>

</div>

<script src="<%= application.getContextPath() %>/js/handledelete.js"></script>
<%@ include file="inclusionfooter.jsp" %>
</body>
</html>
