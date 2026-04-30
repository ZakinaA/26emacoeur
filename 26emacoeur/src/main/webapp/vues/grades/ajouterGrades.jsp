<%-- 
    Document   : ajouterGrades
    Created on : 30 avr. 2026, 08:43:30
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
        <h1>Nouveau Grade</h1>
        
        <form class ="form-inline" action="<%= request.getContextPath() %>/GradesServlet/listerGrades" method="POST">
            
            <label for="labelle">Labelle : </label>
            <input id="labelle" type="text" name="labelle" size="50" maxlength="50">
            <br>
            <input type="submit" name="valider" value="Valider"/>
        </form>
</html>
