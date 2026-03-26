/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoPompier;
import bts.sio.emacoeur.model.Pompier;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class TestDaoPompier {
    
    public static void main(String args[]) throws SQLException{
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        
        ArrayList<Pompier> lesPompiers = DaoPompier.getLesPompiers(cnx);
        System.out.println("Nombre d'elements retournes = " + lesPompiers.size());
        for (Pompier p : lesPompiers){
            System.out.println(". " + p.getPrenom() + "  " + p.getNom() + "  " + p.getStatut() + "  " + p.getCaserne().getNom() + "  " + p.getGrades().getLibelle() + "  " + p.getProfession().getLibelle());
        }
        ConnexionBdd.fermerConnexion(cnx);
    }
}
