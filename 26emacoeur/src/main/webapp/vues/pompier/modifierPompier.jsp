<%-- 
    Document   : modifierPompier
    Created on : 30 avr. 2026, 09:14:22
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bts.sio.emacoeur.model.Pompier"%>
<%@page import="bts.sio.emacoeur.model.Grades"%>
<%@page import="bts.sio.emacoeur.model.Profession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Modifier un pompier</title></head>
<body>
    <h1>Modifier le pompier</h1>
    <%
        Pompier p = (Pompier) request.getAttribute("pPompier");
        ArrayList<Caserne> lesCasernes = (ArrayList<Caserne>) request.getAttribute("pLesCasernes");
        ArrayList<Profession> lesProfessions = (ArrayList<Profession>) request.getAttribute("pLesProfessions");
        ArrayList<Grades> lesGrades = (ArrayList<Grades>) request.getAttribute("pLesGrades");
    %>
    <form method="post" action="/26emacoeur/PompierServlet/modifierPompier">
        <input type="hidden" name="id" value="<%= p.getId() %>"/>

        <label>Nom :</label>
        <input type="text" name="nom" value="<%= p.getNom() %>"/><br/>

        <label>Prénom :</label>
        <input type="text" name="prenom" value="<%= p.getPrenom() %>"/><br/>

        <label>Date de naissance :</label>
        <input type="date" name="dateNaissance" value="<%= p.getDateNaissance() %>"/><br/>

        <label>Numéro bip :</label>
        <input type="number" name="numeroBip" value="<%= p.getNumeroBip() %>"/><br/>

        <label>Statut :</label>
        <input type="text" name="statut" value="<%= p.getStatut() %>"/><br/>

        <label>Caserne :</label>
        <select name="caserne">
            <% for (Caserne c : lesCasernes) { %>
                <option value="<%= c.getId() %>"
                    <%= c.getId() == p.getCaserne().getId() ? "selected" : "" %>>
                    <%= c.getNom() %>
                </option>
            <% } %>
        </select><br/>

        <label>Profession :</label>
        <select name="profession">
            <% for (Profession pro : lesProfessions) { %>
                <option value="<%= pro.getId() %>"
                    <%= pro.getId() == p.getProfession().getId() ? "selected" : "" %>>
                    <%= pro.getLibelle() %>
                </option>
            <% } %>
        </select><br/>

        <label>Grade :</label>
        <select name="grade">
            <% for (Grades g : lesGrades) { %>
                <option value="<%= g.getId() %>"
                    <%= g.getId() == p.getGrades().getId() ? "selected" : "" %>>
                    <%= g.getLibelle() %>
                </option>
            <% } %>
        </select><br/>

        <button type="submit">Enregistrer</button>
        <a href="/26emacoeur/PompierServlet/consulterPompier?id=<%= p.getId() %>">Annuler</a>
    </form>
</body>
</html>
