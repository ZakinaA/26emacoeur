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
        <style>
        body { 
            font-family: Arial, sans-serif;
            max-width: 500px;
            margin: 40px auto;
            padding: 0 20px;
            color: #333;
        }
        h1 { 
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px 14px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th { 
            background: #f5f5f5;
            width: 40%;
            font-weight: 600;
        }
        a { 
            color: #1a6fba;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        </style>
    </head>
    <body>
        <h1>Détails du pompier :</h1>
        <%
            Pompier p = (Pompier) request.getAttribute("pPompier");
            if (p != null) {
        %>
        <a href="/26emacoeur/PompierServlet/modifierPompier?id=<%= p.getId() %>">Modifier ce pompier</a>
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