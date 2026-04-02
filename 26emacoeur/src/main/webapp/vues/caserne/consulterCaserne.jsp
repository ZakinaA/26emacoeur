<%-- 
    Document   : consulterCaserne
    Created on : 2 avr. 2026, 11:43:28
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Caserne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur</title>
    </head>
    <body>
        <h1>Détails du pompier :</h1>
        <%
            Caserne c = (Caserne) request.getAttribute("cCaserne");
            if (c != null) {
        %>
        <table border="1">
            <tr><th>ID</th><td><%= c.getId() %></td></tr>
            <tr><th>Nom</th><td><%= c.getNom() %></td></tr>
            <tr><th>Ville</th><td><%= c.getVille() %></td></tr>
            <tr><th>Code Postal</th><td><%= c.getCp() %></td></tr>
            <tr><th>Rue</th><td><%= c.getRue() %></td></tr>
        </table>
        <%
            } else {
        %>
        <p>Caserne introuvable.</p>
        <%
            }
        %>
        <a href="listerCaserne"> Retour à la liste</a>
    </body>
</html>
