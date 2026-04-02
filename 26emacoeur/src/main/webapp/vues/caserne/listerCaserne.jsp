<%-- 
    Document   : listerCaserne
    Created on : 2 avr. 2026, 09:34:22
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur</title>
    </head>
    <body>
        <h1>liste des casernes :</h1>
        
                    <%
                ArrayList<Caserne> lesCasernes = (ArrayList)request.getAttribute("pLesCasernes");
            %>
            <table>  
            <thead>
                <tr>  
                    <th>id</th>
                    <th>nom</th>
                    <th>ville</th>        
                </tr>
            </thead>
            <tbody>
    <%
        for (Caserne c : lesCasernes) { 
            // On ouvre la ligne AU DÉBUT de chaque passage de boucle
            out.println("<tr>");

            out.println("<td>" + c.getId() + "</td>");
            out.println("<td>" + c.getNom() + "</td>");
            out.println("<td>" + c.getVille() + "</td>");

            // On ferme la ligne À LA FIN de chaque passage de boucle
            out.println("</tr>");
        }
    %>
</tbody>
        </table>
    </body>
</html>
