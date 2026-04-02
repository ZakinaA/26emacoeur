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
    <body>
        <h1>Liste des interventions :</h1>
        <%
                ArrayList<Intervention> lesInterventions = (ArrayList)request.getAttribute("pLesInterventions");
            %>
           <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>Date d'intervention</th>               
                </tr>
            </thead>
            
    <%
        for (Intervention i : lesInterventions)
        {
            out.println("<tr>");          
            out.println("<td>" + i.getId() + "</td>");
            out.println("<td>" + i.getDateIntervention() + "</td>");
            out.println("</tr>");         
        }
    %>
          </table>
    </body>
</html>
