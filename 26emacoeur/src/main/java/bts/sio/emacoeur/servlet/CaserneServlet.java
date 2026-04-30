/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bts.sio.emacoeur.servlet;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoCaserne;
import bts.sio.emacoeur.form.FormCaserne;
import bts.sio.emacoeur.model.Caserne;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class CaserneServlet extends HttpServlet {
    
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
            out.println("<title>Servlet CaserneServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CaserneServlet at " + request.getContextPath() + "</h1>");
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
        
        if(url.equals("/26emacoeur/CaserneServlet/listerCaserne"))
        {
            
             ArrayList lesCasernes = DaoCaserne.getLesCasernes(cnx);
            request.setAttribute("pLesCasernes", lesCasernes);
            System.out.println("lister casernes - nombres de casernes récupérés" + lesCasernes.size() );
            
            getServletContext().getRequestDispatcher("/vues/caserne/listerCaserne.jsp").forward(request, response);
        }
       
        else if (url.equals("/26emacoeur/CaserneServlet/consulterCaserne")) {
        String idParam = request.getParameter("id");
        int idCaserne = Integer.parseInt(idParam);
        Caserne c = DaoCaserne.getCaserneById(cnx, idCaserne);
        request.setAttribute("cCaserne", c);
        getServletContext().getRequestDispatcher("/vues/caserne/consulterCaserne.jsp").forward(request, response);
        return;
    }
        
         else if (url.equals("/26emacoeur/CaserneServlet/ajouterCaserne")) {
             this.getServletContext().getRequestDispatcher("/vues/caserne/ajouterCaserne.jsp").forward(request, response);
             return;
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
        
        if (url.equals("/26emacoeur/CaserneServlet/ajouterCaserne")) {

        FormCaserne formCaserne = new FormCaserne();
        Caserne uneCaserne = formCaserne.ajouterCaserne(request);

        request.setAttribute("formCaserne", formCaserne);
        request.setAttribute("cCaserne", uneCaserne);

        if (formCaserne.getErreurs().isEmpty()) {
            Caserne caserneInsere = DaoCaserne.ajouterCaserne(cnx, uneCaserne);
            if (caserneInsere != null) {
                getServletContext().getRequestDispatcher("/vues/caserne/consulterCaserne.jsp")
                        .forward(request, response);
            }
        } else {
// Recharger les listes pour réafficher le formulaire
                        getServletContext().getRequestDispatcher("/vues/caserne/ajouterCaserne.jsp")
                    .forward(request, response);
        }
    }
        processRequest(request, response);
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
