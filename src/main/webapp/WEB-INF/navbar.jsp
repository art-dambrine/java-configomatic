<%--
  Created by IntelliJ IDEA.
  User: arthurdambrine
  Date: 21/11/2020
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="<%= application.getContextPath() %>/">
        <img src="img/wheels-icon.png" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
        ConfigoMatic
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item <% if(request.getServletPath().equals("/index.jsp")) out.print("active");%>">
                <a class="nav-link" href="<%= application.getContextPath() %>/">Home</a>
            </li>
            <li class="nav-item <% if(request.getServletPath().equals("/WEB-INF/ordinateurs.jsp")) out.print("active");%>">
                <a class="nav-link" href="<%= application.getContextPath() %>/ordinateurs">Ordinateurs</a>
            </li>
            <li class="nav-item <% if(request.getServletPath().equals("/WEB-INF/config.jsp")) out.print("active");%>">
                <a class="nav-link" href="<%= application.getContextPath() %>/config">Config</a>
            </li>
            <li class="nav-item">
                <a class="nav-link h-100 nav-github" href="https://github.com/art-dambrine/java-configomatic" target="_blank"><img
                        width="20" height="20" src="img/github.png" title="GitHub" alt="GitHub"></a>
            </li>
        </ul>
    </div>
</nav>
