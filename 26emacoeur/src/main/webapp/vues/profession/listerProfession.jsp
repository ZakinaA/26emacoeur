<%-- 
    Document   : listerProfession
    Created on : 4 avr. 2026, 07:46:13
    Author     : jules
--%>

<%@page import="bts.sio.emacoeur.model.Profession"%>
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
        <h1>Liste des Professions :</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Ville</th>
            </tr>
            <%
                ArrayList<Profession> lesProfessions = (ArrayList<Profession>) request.getAttribute("pLesProfessions");
            %>
            <%
                for (Profession p : lesProfessions) { 
                    out.println("<tr>");
                    out.println("<td>" + p.getId() + "</td>");
                    out.println("<td>" + p.getLibelle() + "</td>");
                    out.println("<td>" + p.getVille() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>