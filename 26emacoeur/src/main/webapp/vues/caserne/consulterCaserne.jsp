<%-- 
    Document   : consulterCaserne
    Created on : 30 avr. 2026, 08:40:41
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Caserne"%>
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
        <h1>Detail de la caserne :</h1>
                <%
            Caserne c = (Caserne) request.getAttribute("cCaserne");
            if (c != null) {
        %>
        <table border="1">
            <tr><th>ID</th><td><%= c.getId() %></td></tr>
            <tr><th>Nom</th><td><%= c.getNom() %></td></tr>
            <tr><th>Prénom</th><td><%= c.getVille() %></td></tr>
            <tr><th>Date naissance</th><td><%= c.getCp() %></td></tr>
            <tr><th>Numéro bip</th><td><%= c.getRue() %></td></tr>
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
