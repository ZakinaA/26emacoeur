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
            
    <%
        for (Caserne c : lesCasernes) { 
            // On ouvre la ligne AU DÉBUT de chaque passage de boucle
            out.println("<tr>");

            out.println("<td>" + c.getId() + "</td>");
            %>
            
            <td><a href="consulterCaserne?id=<%= c.getId() %>">
                        <%= c.getNom() %>
                    </a>
                    </td>
            
            <%
            out.println("<td>" + c.getVille() + "</td>");

            // On ferme la ligne À LA FIN de chaque passage de boucle
            out.println("</tr>");
        }
    %>

        </table>
    <a href="<%= request.getContextPath() %>/CaserneServlet/ajouterCaserne"><button>Nouvel caserne</button></a>
    </body>
</html>
