<%@page import="bts.sio.emacoeur.model.Pompier"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur - Liste des Pompiers</title>
        <style>
            /* On reprend la charte graphique identique aux autres pages */
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

            .table-container {
                display: flex;
                justify-content: center;
            }

            table {
                width: 90%;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                border-radius: 8px;
                overflow: hidden;
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

            tr:hover {
                background-color: #f1f1f1;
                transition: background-color 0.3s ease;
            }

            /* Style spécifique pour le lien de consultation */
            .link-pompier {
                color: #d32f2f;
                text-decoration: none;
                font-weight: bold;
            }

            .link-pompier:hover {
                text-decoration: underline;
            }

            /* Style du bouton retour */
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

        <h1>👨‍🚒 Liste des pompiers</h1>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Date de naissance</th>
                        <th>Numéro bip</th>
                        <th>Statut</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Pompier> lesPompiers = (ArrayList<Pompier>) request.getAttribute("pLesPompiers");
                        if (lesPompiers != null && !lesPompiers.isEmpty()) {
                            for (Pompier p : lesPompiers) {
                    %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td>
                            <a class="link-pompier" href="consulterPompier?id=<%= p.getId() %>">
                                <%= p.getNom() %>
                            </a>
                        </td>
                        <td><%= p.getPrenom() %></td>
                        <td><%= p.getDateNaissance() %></td>
                        <td><%= p.getNumeroBip() %></td>
                        <td><%= p.getStatut() %></td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6">Aucun pompier trouvé dans la base de données.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <a href="${pageContext.request.contextPath}/" class="btn-retour">
            ⬅ Retour à l'accueil
        </a>

    </body>
</html>