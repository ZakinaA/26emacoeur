<%@page import="bts.sio.emacoeur.model.Pompier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emacoeur - Fiche Pompier</title>
        <style>
            /* Charte graphique Emacoeur */
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

            /* Style de la fiche (Card) */
            .pompier-card {
                background-color: white;
                width: 500px;
                margin: 0 auto;
                padding: 20px;
                border-radius: 12px;
                box-shadow: 0 10px 20px rgba(0,0,0,0.1);
                border-top: 8px solid #d32f2f; /* Rappel rouge en haut */
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 10px;
            }

            th {
                text-align: left;
                padding: 12px;
                color: #7f8c8d;
                border-bottom: 1px solid #eee;
                width: 40%;
                font-size: 14px;
                text-transform: uppercase;
            }

            td {
                text-align: right;
                padding: 12px;
                font-weight: bold;
                color: #2c3e50;
                border-bottom: 1px solid #eee;
            }

            /* Zone des boutons */
            .actions {
                margin-top: 30px;
            }

            .btn {
                display: inline-block;
                padding: 10px 20px;
                margin: 5px;
                text-decoration: none;
                border-radius: 5px;
                font-weight: bold;
                transition: 0.3s;
            }

            .btn-back {
                background-color: #bdc3c7;
                color: #2c3e50;
            }

            .btn-back:hover { background-color: #95a5a6; }

            .btn-home {
                background-color: #2c3e50;
                color: white;
            }

            .btn-home:hover { background-color: #34495e; }
            
            .error-msg { color: #d32f2f; font-weight: bold; }
        </style>
    </head>
    <body>

        <h1>Fiche Individuelle</h1>

        <div class="pompier-card">
            <%
                Pompier p = (Pompier) request.getAttribute("pPompier");
                if (p != null) {
            %>
                <table>
                    <tr><th>ID</th><td><%= p.getId() %></td></tr>
                    <tr><th>Nom</th><td><%= p.getNom() %></td></tr>
                    <tr><th>Prénom</th><td><%= p.getPrenom() %></td></tr>
                    <tr><th>Date naissance</th><td><%= p.getDateNaissance() %></td></tr>
                    <tr><th>Numéro bip</th><td><%= p.getNumeroBip() %></td></tr>
                    <tr><th>Statut</th><td><%= p.getStatut() %></td></tr>
                    
                    <%-- Attention aux objets liés, on vérifie s'ils existent pour éviter les bugs --%>
                    <tr><th>Profession</th><td><%= (p.getProfession() != null) ? p.getProfession().getLibelle() : "N/A" %></td></tr>
                    <tr><th>Grade</th><td><%= (p.getGrades() != null) ? p.getGrades().getLibelle() : "N/A" %></td></tr>
                    <tr><th>Caserne</th><td><%= (p.getCaserne() != null) ? p.getCaserne().getNom() : "N/A" %></td></tr>
                </table>
            <%
                } else {
            %>
                <p class="error-msg">⚠️ Pompier introuvable ou erreur de chargement.</p>
            <%
                }
            %>
        </div>

        <div class="actions">
            <a href="listerPompier" class="btn btn-back">⬅ Retour à la liste</a>
            
            <a href="${pageContext.request.contextPath}/" class="btn btn-home">🏠 Accueil</a>
        </div>

    </body>
</html>