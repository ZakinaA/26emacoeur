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
        <h1>Liste des pompiers :</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date naissance</th>
                <th>Numéro bip</th>
                <th>Statut</th>
                <th>Profession</th>
                <th>Grade</th>
                <th>Caserne</th>
              
            </tr>
            <%
                ArrayList<Pompier> lesPompiers = (ArrayList<Pompier>) request.getAttribute("pLesPompiers");
                if (lesPompiers != null && !lesPompiers.isEmpty()) {
                    for (Pompier p : lesPompiers) {  
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNom() %></td>
                <td><%= p.getPrenom() %></td>
                <td><%= p.getDateNaissance() %></td>
                <td><%= p.getNumeroBip() %></td>
                <td><%= p.getStatut() %></td>
                <td><%= p.getProfession().getLibelle() %></td>
                <td><%= p.getGrades().getLibelle() %></td>
                <td><%= p.getCaserne().getNom() %></td>
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
    </body>
</html>