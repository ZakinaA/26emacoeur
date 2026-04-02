<%@page import="java.util.ArrayList"%>
<%@page import="bts.sio.emacoeur.model.Intervention"%>
<%@page import="bts.sio.emacoeur.model.TypeIntervention"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur - Liste des Interventions</title>
        <style>
            /* Style général identique aux casernes */
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f4f7f6;
                color: #333;
                margin: 40px;
                text-align: center;
            }

            h1 {
                color: #d32f2f;
                text-transform: uppercase;
                margin-bottom: 30px;
            }

            /* Style du tableau */
            .table-container {
                display: flex;
                justify-content: center;
            }

            table {
                width: 70%;
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

        <h1>🚨 Liste des interventions</h1>

        <div class="table-container">
            <table>  
                <thead>
                    <tr>              
                        <th>ID</th>
                        <th>Date de l'intervention</th>                
                    </tr>
                </thead>
                <tbody>
                <% 
                    ArrayList<Intervention> lesInterventions = (ArrayList<Intervention>)request.getAttribute("pLesInterventions");
                    if(lesInterventions != null && !lesInterventions.isEmpty()) { 
                        for (Intervention i : lesInterventions) {
                %>
                    <tr>
                        <td><strong><%= i.getId() %></strong></td>
                        <td><%= i.getDateIntervention() %></td>
                    </tr>
                <% 
                        }
                    } else { 
                %>
                    <tr>
                        <td colspan="2">Aucune intervention enregistrée.</td>
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