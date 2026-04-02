/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import java.sql.*;

/**
 *
 * @author ts1sio
 */
public class ConnexionBdd implements ServletContextListener {
    
    public static Connection connection = null;
    public static Statement st = null;
    public static ResultSet rs = null;

    @Override
    
    public void contextInitialized(ServletContextEvent sce) {
        Connection cnx = ouvrirConnexion();
        sce.getServletContext().setAttribute("connection", cnx);
        System.out.println("Connexion stockée dans le contexte");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Connection cnx = (Connection) sce.getServletContext().getAttribute("connection");
        fermerConnexion(cnx);
    }
       
    public static Connection ouvrirConnexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Pilote MARIADB JDBC chargé");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();         
        }     
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3307/26emacoeur", "root", "");
            System.out.println("Connexion OK");
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return connection;
    }
    
    public static void fermerConnexion(ResultSet rs) {
        if (rs != null) {
            try { rs.close(); }
            catch(Exception e) { System.out.println("Erreur fermeture ResultSet"); }
        }
    }

    public static void fermerConnexion(Statement stmt) {
        if (stmt != null) {
            try { stmt.close(); }
            catch(Exception e) { System.out.println("Erreur fermeture Statement"); }
        }
    }

    public static void fermerConnexion(Connection con) {
        if (con != null) {
            try { 
                con.close(); 
                System.out.println("Fermeture Connexion OK");
            }
            catch(Exception e) { System.out.println("Erreur fermeture Connection"); }
        }
    }
}
