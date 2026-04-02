<%@page import="bts.sio.emacoeur.model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur - Liste des Casernes</title>
        <style>
            /* Style général */
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f6;
                color: #333;
                margin: 40px;
                text-align: center;
            }

            h1 {
                color: #d32f2f; /* Rouge Pompier */
                text-transform: uppercase;
                margin-bottom: 30px;
            }

            /* Style du tableau */
            .table-container {
                display: flex;
                justify-content: center;
            }

            table {
                width: 80%;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                border-radius: 8px;
                overflow: hidden; /* Pour les coins arrondis */
            }

            th {
                background-color: #d32f2f;
                color: white;
                padding: 15px;
                text-transform: uppercase;
                font-size: 14px;
            }

            td {
                padding: 12px 15px;
                border-bottom: 1px solid #ddd;
            }

            /* Effet au survol des lignes */
            tr:hover {
                background-color: #f1f1f1;
                transition: background-color 0.3s ease;
            }

            /* Style du bouton */
            .btn-retour {
                display: inline-block;
                margin-top: 30px;
                padding: 12px 25px;
                background-color: #2c3e50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-weight: bold;
                transition: background-color 0.3s ease;
            }

            .btn-retour:hover {
                background-color: #34495e;
            }
        </style>
    </head>
    <body>

        <h1>🚒 Liste des casernes</h1>

        <div class="table-container">
            <table>  
                <thead>
                    <tr>  
                        <th>ID</th>
                        <th>Nom de la Caserne</th>
                        <th>Ville</th>        
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Caserne> lesCasernes = (ArrayList)request.getAttribute("pLesCasernes");
                        if (lesCasernes != null) {
                            for (Caserne c : lesCasernes) { 
                    %>
                        <tr>
                            <td><strong><%= c.getId() %></strong></td>
                            <td><%= c.getNom() %></td>
                            <td><%= c.getVille() %></td>
                        </tr>
                    <% 
                            }
                        } else {
                    %>
                        <tr>
                            <td colspan="3">Aucune donnée disponible.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>

        <a href="${pageContext.request.contextPath}/" class="btn-retour">
    ⬅ Retour à l'accueil
</a>

    </body>
</html>