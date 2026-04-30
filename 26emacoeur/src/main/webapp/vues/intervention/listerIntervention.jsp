<%-- 
    Document   : listerIntervention
    Created on : 2 avr. 2026, 09:09:54
    Author     : ts1sio
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="bts.sio.emacoeur.model.Intervention"%>
<%@page import="bts.sio.emacoeur.model.TypeIntervention"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur</title>
    </head>
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
    <body>
        <h1>Liste des interventions :</h1>
        <%
            ArrayList<Intervention> lesInterventions = (ArrayList<Intervention>)request.getAttribute("pLesInterventions");
        %>
        <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Date d'intervention</th>               
                </tr>
            </thead>
            <tbody>
            <% if(lesInterventions != null) { %>
                <%
                    for (Intervention i : lesInterventions)
                    {
                        out.println("<tr>");          
                        out.println("<td>" + i.getId() + "</td>");
                        out.println("<td>" + i.getDateIntervention() + "</td>");
                        out.println("</tr>");         
                    }
                %>
            <% } else { %>
                <tr><td colspan="2">Aucune intervention trouvée.</td></tr>
            <% } %>
            </tbody>
        </table>