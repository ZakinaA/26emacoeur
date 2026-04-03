<%-- 
    Document   : addPompier
    Created on : 3 avr. 2026, 22:12:02
    Author     : jules
--%>

<%@page import="bts.sio.emacoeur.model.Grades"%>
<%@page import="bts.sio.emacoeur.model.Profession"%>
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
        <h1>Nouveau Pompier</h1>
        
        <form class ="form-inline" action="<%= request.getContextPath() %>/PompierServlet/ajouterPompier" method="POST">
            <label for="prenom">Prenom : </label>
            <input id="prenom" type="text" name="prenom" size="50" maxlength="50">
            <br>
            
            <label for="nom">Nom : </label>
            <input id="nom" type="text" name="nom" size="50" maxlength="50">
            <br>
            
            <label for="statut">Statut : </label>
            <input id="statut" type="text" name="statut" size="50" maxlength="50">
            <br>
             
            <label for="numerobip">NumeroBip : </label>
            <input id="numerobip" type="int" name="numerobip" size="11" maxlength="11">
            <br>
            
            <label for="caserne">Caserne : </label>
            <select name="maison_id">
            <%
                ArrayList<Caserne> lesCasernes = (ArrayList)request.getAttribute("pLesCasernes");
                for (Caserne c : lesCasernes){
                    out.println("<option value ='"+c.getId()+"'>" + c.getNom()+"</option>");
                }
            %>
            </select>
            </br>
            <label for="profession">Profession : </label>
            <select name="pro_id">
                <%
                    ArrayList<Profession> lesProfessions = (ArrayList<Profession>) request.getAttribute("pLesProfessions");
                    for (Profession p : lesProfessions) {
                        out.println("<option value='" + p.getId() + "'>" + p.getLibelle() + "</option>");
                    }
                %>
            </select>
            </br>
            <label for="grade">Grade : </label>
            <select name="gra_id">
                <%
                    ArrayList<Grades> lesGrades = (ArrayList<Grades>) request.getAttribute("pLesGrades");
                    for (Grades g : lesGrades) {
                        out.println("<option value='" + g.getId() + "'>" + g.getLibelle() + "</option>");
                    }
                %>
            </select>
            <input type="submit" name="valider" value="Valider"/>
        </form>
    </body>
</html>
