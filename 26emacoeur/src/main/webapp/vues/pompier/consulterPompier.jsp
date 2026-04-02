<%-- 
    Document   : listerPompier
    Created on : 2 avr. 2026, 08:36:01
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Pompier"%>
<%@page import="java.util.ArrayList"%>
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
            Pompier p = (Pompier) request.getAttribute("pPompier");
            if (p != null) {
        %>
        <table border="1">
            <tr><th>ID</th><td><%= p.getId() %></td></tr>
            <tr><th>Nom</th><td><%= p.getNom() %></td></tr>
            <tr><th>Prénom</th><td><%= p.getPrenom() %></td></tr>
            <tr><th>Date naissance</th><td><%= p.getDateNaissance() %></td></tr>
            <tr><th>Numéro bip</th><td><%= p.getNumeroBip() %></td></tr>
            <tr><th>Statut</th><td><%= p.getStatut() %></td></tr>
            <tr><th>Profession</th><td><%= p.getProfession().getLibelle() %></td></tr>
            <tr><th>Grade</th><td><%= p.getGrades().getLibelle() %></td></tr>
            <tr><th>Caserne</th><td><%= p.getCaserne().getNom() %></td></tr>
        </table>
        <%
            } else {
        %>
        <p>Pompier introuvable.</p>
        <%
            }
        %>
        <a href="listerPompier"> Retour à la liste</a>
    </body>
</html>