<%-- 
    Document   : ajouterCaserne
    Created on : 30 avr. 2026, 09:14:43
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nouvel Caserne :</h1>
        
        <form class ="form-inline" action="<%= request.getContextPath() %>/CaserneServlet/ajouterCaserne" method="POST">
            <label for="nom">Nom : </label>
            <input id="nom" type="text" name="nom" size="50" maxlength="50">
            <br>
            
            <label for="nom">Ville : </label>
            <input id="ville" type="text" name="ville" size="50" maxlength="50">
            <br>
            
            <label for="statut">Cp : </label>
            <input id="cp" type="text" name="cp" size="50" maxlength="50">
            <br>
             
            <label for="numerobip">Rue : </label>
            <input id="rue" type="int" name="rue" size="11" maxlength="11">
            <br>
            
            <input type="submit" name="valider" value="Valider"/>
        </form>
    </body>
</html>
