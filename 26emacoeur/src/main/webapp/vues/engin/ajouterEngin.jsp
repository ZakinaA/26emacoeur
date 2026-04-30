<%-- 
    Document   : ajouterEngin
    Created on : 30 avr. 2026, 09:41:53
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur</title>
    </head>
    <body>
        <h1>Nouveau Engin</h1>
        
        <form class ="form-inline" action="<%= request.getContextPath() %>/EnginServlet/listerEngin" method="POST">
            
            <label for="type">Type : </label>
            <input id="type" type="text" name="type" size="50" maxlength="50">
            <br>
            <input type="submit" name="valider" value="Valider"/>
        </form>
</html>
