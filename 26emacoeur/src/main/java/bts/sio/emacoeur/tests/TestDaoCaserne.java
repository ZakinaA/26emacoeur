/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoCaserne;
import bts.sio.emacoeur.model.Caserne;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class TestDaoCaserne {
    
     public static void main(String args[]) throws SQLException{
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        
        ArrayList<Caserne> lesCasernes = DaoCaserne.getLesCasernes(cnx);
        System.out.println("Nombre d'elements retournes = " + lesCasernes.size());
        for (Caserne c : lesCasernes){
            System.out.println(". " + c.getNom() + "  " + c.getVille() + "  " + c.getCp() + "  " + c.getRue());
        }
        ConnexionBdd.fermerConnexion(cnx);
    }
}
    
