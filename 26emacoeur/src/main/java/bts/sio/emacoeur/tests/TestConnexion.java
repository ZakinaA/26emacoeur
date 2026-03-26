/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.database.ConnexionBdd;
import java.sql.Connection;

/**
 *
 * @author nathan
 */
public class TestConnexion {
    
    public static void main(String[] args) {
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        ConnexionBdd.fermerConnexion(cnx);
    }
    
}
