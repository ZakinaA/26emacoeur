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
            max-width: 900px;
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
            font-weight: 600;
        }
        tr:hover td { 
            background: #fafafa;
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
        <h1>Liste des pompiers :</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date naissance</th>
                <th>Numéro bip</th>
                <th>Statut</th>
            </tr>
            <%
                ArrayList<Pompier> lesPompiers = (ArrayList<Pompier>) request.getAttribute("pLesPompiers");
                if (lesPompiers != null && !lesPompiers.isEmpty()) {
                    for (Pompier p : lesPompiers) {  
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><a href="consulterPompier?id=<%= p.getId() %>">
                        <%= p.getNom() %>
                    </a>
                    </td>
                <td><%= p.getPrenom() %></td>
                <td><%= p.getDateNaissance() %></td>
                <td><%= p.getNumeroBip() %></td>
                <td><%= p.getStatut() %></td>

            </tr>
            <%
                    } 
                } else {
            %>
            <tr><td colspan="9">Aucun pompier trouvé</td></tr>
            <%
                }
            %>
        </table>
        <a href="<%= request.getContextPath() %>/PompierServlet/ajouterPompier"><button>Nouveau Pompier</button></a>
    </body>
</html>