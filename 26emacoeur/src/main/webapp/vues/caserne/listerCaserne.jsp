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
                <tr>
                    <%
                        for (Caserne c : lesCasernes)
                        {              
                            out.println("<td>");
                            out.println(c.getId());
                            out.println("</a></td>");

                            out.println("<td>");
                            out.println(c.getNom());
                            out.println("</td>");

                            out.println("<td>");
                            out.println(c.getVille());
                            out.println("</td>");
                            
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
