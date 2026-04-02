<%-- 
    Document   : listerEngin
    Created on : 2 avr. 2026, 11:46:32
    Author     : nathan
--%>

<%@page import="bts.sio.emacoeur.model.Engin"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lister engin</title>
    </head>
    <h1>Liste Engin</h1>
    <table border="1">
            <tr>
                <th>ID</th>
                <th>Type</th>              
            </tr>
            <%
                ArrayList<Engin> desEngins = (ArrayList<Engin>) request.getAttribute("pDesEngins");
                if (desEngins != null && !desEngins.isEmpty()) {
                    for (Engin e : desEngins) {  
            %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getType()%></td>
                
            </tr>
            <%
                    } 
                } else {
            %>
            <tr><td colspan="9">Aucun engin trouvé</td></tr>
            <%
                }
            %>
        </table>
    </body>
</html>
    