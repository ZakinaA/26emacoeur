/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Pompier;
import bts.sio.emacoeur.model.Profession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jules
 */
public class DaoPompier {
    
    
    Connection cnx = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    public static ArrayList<Pompier> getLesPompiers(Connection cnx) throws SQLException {
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        try {
            // Requête corrigée (ajout de pom.nom et des virgules/espaces)
            requete = cnx.prepareStatement(
                "SELECT pom.id as pom_id, pom.nom as pom_nom, pom.prenom as pom_prenom, " +
                "pom.dateNaissance as pom_dateNaissance, pom.numeroBip as pom_numeroBip, " +
                "pom.statut as pom_statut, pro.id as pro_id, pro.libelle as pro_libelle, " +
                "gra.id as gra_id, gra.libelle as gra_libelle, cas.id as cas_id, cas.nom as cas_nom " +
                "FROM pompier pom " +
                "INNER JOIN profession pro ON pom.profession_id = pro.id " +
                "INNER JOIN grades gra ON pom.grades_id = gra.id " +
                "INNER JOIN caserne cas ON pom.caserne_id = cas.id"
            );
            
            rs = requete.executeQuery();
            
            while (rs.next()) {
                Pompier unPompier = new Pompier();
                unPompier.setId(rs.getInt("pom_id"));
                unPompier.setNom(rs.getString("pom_nom"));
                unPompier.setPrenom(rs.getString("pom_prenom"));
                unPompier.setNumeroBip(rs.getInt("pom_numeroBip"));
                unPompier.setStatut(rs.getString("pom_statut"));
                
                
                java.sql.Date sqlDate = rs.getDate("pom_dateNaissance");
                if (sqlDate != null) {
                    unPompier.setDateNaissance(sqlDate.toLocalDate());
                }
                
                // Partie Profession
                Profession pro = new Profession();
                pro.setId(rs.getInt("pro_id"));
                pro.setLibelle(rs.getString("pro_libelle"));
                unPompier.setProfession(pro);
                
                // Partie Grades
                Grades gra = new Grades();
                gra.setId(rs.getInt("gra_id"));
                gra.setLibelle(rs.getString("gra_libelle"));
                unPompier.setGrades(gra);
                
                // Partie Caserne
                Caserne cas = new Caserne();
                cas.setId(rs.getInt("cas_id"));
                cas.setNom(rs.getString("cas_nom"));
                unPompier.setCaserne(cas);
                
                lesPompiers.add(unPompier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return lesPompiers; // Retourne la liste remplie
    }
}