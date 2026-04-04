/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bts.sio.emacoeur.servlet;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoCaserne;
import bts.sio.emacoeur.database.DaoGrades;
import bts.sio.emacoeur.database.DaoPompier;
import bts.sio.emacoeur.database.DaoProfession;
import bts.sio.emacoeur.form.FormPompier;
import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Pompier;
import bts.sio.emacoeur.model.Profession;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
public class PompierServlet extends HttpServlet {
    
    Connection cnx ;
            
    @Override
    public void init()
    {     
        cnx = ConnexionBdd.ouvrirConnexion();
    }
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PompierServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PompierServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String url = request.getRequestURI();
    
    if (url.equals("/26emacoeur/PompierServlet/listerPompier")) {
        try {
            ArrayList lesPompiers = DaoPompier.getLesPompiers(cnx);
            request.setAttribute("pLesPompiers", lesPompiers);
            getServletContext().getRequestDispatcher("/vues/pompier/listerPompier.jsp").forward(request, response);
            return;
        } catch (SQLException ex) {
            System.getLogger(PompierServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    else if (url.equals("/26emacoeur/PompierServlet/consulterPompier")) {
        String idParam = request.getParameter("id");
        int idPompier = Integer.parseInt(idParam);
        Pompier p = DaoPompier.getPompierById(cnx, idPompier);
        request.setAttribute("pPompier", p);
        getServletContext().getRequestDispatcher("/vues/pompier/consulterPompier.jsp").forward(request, response);
        return;
    }
    else if (url.equals("/26emacoeur/PompierServlet/ajouterPompier")) {
        try {
            
            ArrayList<Caserne> lesCasernes = DaoCaserne.getLesCasernes(cnx);
            request.setAttribute("pLesCasernes", lesCasernes);
            
            ArrayList<Profession> lesProfessions = DaoProfession.getLesProfessions(cnx);
            request.setAttribute("pLesProfessions", lesProfessions);
            
             ArrayList<Grades> lesGrades = DaoGrades.getLesGrades(cnx);
             request.setAttribute("pLesGrades", lesGrades);
            
            
            this.getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp").forward(request, response);
            return;
        } catch (SQLException ex) {
            System.getLogger(PompierServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    processRequest(request, response);
}
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    String url = request.getRequestURI();

    if (url.equals("/26emacoeur/PompierServlet/ajouterPompier")) {

        FormPompier formPompier = new FormPompier();
        Pompier unPompier = formPompier.ajouterPompier(request);

        request.setAttribute("formPompier", formPompier);
        request.setAttribute("pPompier", unPompier);

        if (formPompier.getErreurs().isEmpty()) {
            Pompier pompierInsere = DaoPompier.ajouterPompier(cnx, unPompier);
            if (pompierInsere != null) {
                getServletContext().getRequestDispatcher("/vues/pompier/consulterPompier.jsp")
                        .forward(request, response);
            }
        } else {
            // Recharger les listes pour réafficher le formulaire
            try {
                request.setAttribute("pLesCasernes", DaoCaserne.getLesCasernes(cnx));
                request.setAttribute("pLesProfessions", DaoProfession.getLesProfessions(cnx));
                request.setAttribute("pLesGrades", DaoGrades.getLesGrades(cnx));
            } catch (SQLException ex) {
                System.getLogger(PompierServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            getServletContext().getRequestDispatcher("/vues/pompier/ajouterPompier.jsp")
                    .forward(request, response);
        }
    }
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
