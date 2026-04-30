<%-- 
    Document   : listerGrade
    Created on : 30 avr. 2026, 08:38:22
    Author     : ts1sio
--%>

<%@page import="bts.sio.emacoeur.model.Grades"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur-ListeGrade</title>   
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
        <h1>Liste des Grades : </h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Libelle</th>
            </tr>
           <%
                ArrayList<Grades> lesGrades = (ArrayList<Grades>) request.getAttribute("pLesGrades");
                if (lesGrades != null && !lesGrades.isEmpty()) {
                    for (Grades g : lesGrades) {  
            %>
            <tr>
                <td><%= g.getId() %></td>
                <td><a href="consulterGrades?id=<%=g.getId() %>">
                        <%= g.getLibelle()%>
                    </a>
                </td>
            </tr>
            <%
                    } 
                } else {
            %>
            <tr><td colspan="9">Aucun grade trouvé</td></tr>
            <%
                }
            %>
            <a href="<%= request.getContextPath() %>/GradesServlet/ajouterGrades"><button>Nouveau Grade</button></a>
    </body>
</html>
