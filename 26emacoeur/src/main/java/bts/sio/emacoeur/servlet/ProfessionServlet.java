/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bts.sio.emacoeur.servlet;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoProfession;
import bts.sio.emacoeur.form.FormProfession;
import bts.sio.emacoeur.model.Profession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class ProfessionServlet extends HttpServlet {

    Connection cnx;

    @Override
    public void init() {
        cnx = ConnexionBdd.ouvrirConnexion();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals("/26emacoeur/ProfessionServlet/listerProfession")) {
            try {
                ArrayList<Profession> lesProfessions = DaoProfession.getLesProfessions(cnx);
                request.setAttribute("pLesProfessions", lesProfessions);
                getServletContext().getRequestDispatcher("/vues/profession/listerProfession.jsp")
                        .forward(request, response);
                return;
            } catch (SQLException ex) {
                System.getLogger(ProfessionServlet.class.getName())
                        .log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        else if (url.equals("/26emacoeur/ProfessionServlet/consulterProfession")) {
            String idParam = request.getParameter("id");
            int idProfession = Integer.parseInt(idParam);

            Profession p = DaoProfession.getProfessionById(cnx, idProfession);
            request.setAttribute("pProfession", p);
            getServletContext().getRequestDispatcher("/vues/profession/consulterProfession.jsp")
                    .forward(request, response);
        }
        else if (url.equals("/26emacoeur/ProfessionServlet/ajouterProfession")) {
            getServletContext().getRequestDispatcher("/vues/profession/ajouterProfession.jsp")
                    .forward(request, response);
        }
        else {
            processRequest(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getRequestURI();

        if (url.equals("/26emacoeur/ProfessionServlet/ajouterProfession")) {

            FormProfession formProfession = new FormProfession();
            Profession uneProfession = formProfession.ajouterProfession(request);
            request.setAttribute("formProfession", formProfession);
            request.setAttribute("pProfession", uneProfession);

            if (formProfession.getErreurs().isEmpty()) {
                Profession professionInseree = DaoProfession.ajouterProfession(cnx, uneProfession);
                if (professionInseree != null) {
                    getServletContext().getRequestDispatcher("/vues/profession/consulterProfession.jsp")
                            .forward(request, response);
                }
            } else {
                // Retour au formulaire avec les erreurs
                getServletContext().getRequestDispatcher("/vues/profession/ajouterProfession.jsp")
                        .forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}