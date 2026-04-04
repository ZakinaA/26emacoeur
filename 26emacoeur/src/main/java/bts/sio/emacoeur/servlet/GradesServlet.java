/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.servlet;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoGrades;
import bts.sio.emacoeur.form.FormGrades;
import bts.sio.emacoeur.model.Grades;
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
 * @author jules
 */
public class GradesServlet extends HttpServlet {

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
            out.println("<html><head><title>GradesServlet</title></head>");
            out.println("<body><h1>GradesServlet at " + request.getContextPath() + "</h1></body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals("/26emacoeur/GradesServlet/listerGrades")) {
            try {
                ArrayList<Grades> lesGrades = DaoGrades.getLesGrades(cnx);
                request.setAttribute("pLesGrades", lesGrades);
                getServletContext().getRequestDispatcher("/vues/grades/listerGrades.jsp")
                        .forward(request, response);
                return;
            } catch (SQLException ex) {
                System.getLogger(GradesServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        else if (url.equals("/26emacoeur/GradesServlet/consulterGrades")) {
            String idParam = request.getParameter("id");
            int idGrade = Integer.parseInt(idParam);
            Grades g = DaoGrades.getGradeById(cnx, idGrade);
            request.setAttribute("pGrades", g);
            getServletContext().getRequestDispatcher("/vues/grades/consulterGrades.jsp")
                    .forward(request, response);
            return;
        }
        else if (url.equals("/26emacoeur/GradesServlet/ajouterGrades")) {
            getServletContext().getRequestDispatcher("/vues/grades/ajouterGrades.jsp")
                    .forward(request, response);
            return;
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();

        if (url.equals("/26emacoeur/GradesServlet/ajouterGrades")) {
            FormGrades formGrades = new FormGrades();
            Grades unGrade = formGrades.ajouterGrades(request);

            request.setAttribute("formGrades", formGrades);
            request.setAttribute("pGrades", unGrade);

            if (formGrades.getErreurs().isEmpty()) {
                Grades gradeInsere = DaoGrades.ajouterGrade(cnx, unGrade);
                if (gradeInsere != null) {
                    getServletContext().getRequestDispatcher("/vues/grades/consulterGrades.jsp")
                            .forward(request, response);
                }
            } else {
                getServletContext().getRequestDispatcher("/vues/grades/ajouterGrades.jsp")
                        .forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}