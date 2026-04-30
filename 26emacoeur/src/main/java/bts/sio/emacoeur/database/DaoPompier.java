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
            
            requete = cnx.prepareStatement(
                    "SELECT pom.pom_id, pom.pom_nom, pom.pom_prenom, " +
                    "pom.pom_dateNaissance, pom.pom_numeroBip, pom.pom_statut, " +
                    "pro.pro_id, pro.pro_libelle, " +
                    "gra.gra_id, gra.gra_libelle, " +
                    "cas.cas_id, cas.cas_nom " +
                    "FROM pompier pom " +
                    "INNER JOIN profession pro ON pom.pro_id = pro.pro_id " +
                    "INNER JOIN grades gra ON pom.gra_id = gra.gra_id " +
                    "INNER JOIN caserne cas ON pom.cas_id = cas.cas_id"
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
    
public static Pompier getPompierById(Connection cnx, int idPompier) {
    Pompier unPompier = new Pompier();
    try {
        requete = cnx.prepareStatement(
        "SELECT pom.pom_id, pom.pom_nom, pom.pom_prenom, " +
        "pom.pom_dateNaissance, pom.pom_numeroBip, pom.pom_statut, " +
        "pro.pro_id, pro.pro_libelle, " +
        "gra.gra_id, gra.gra_libelle, " +
        "cas.cas_id, cas.cas_nom " +
        "FROM pompier pom " +
        "INNER JOIN profession pro ON pom.pro_id = pro.pro_id " +
        "INNER JOIN grades gra ON pom.gra_id = gra.gra_id " +
        "INNER JOIN caserne cas ON pom.cas_id = cas.cas_id " +
        "WHERE pom.pom_id = ?"   // ← seule différence avec getLesPompiers
        );
        requete.setInt(1, idPompier);
        rs = requete.executeQuery();

        if (rs.next()) {
            unPompier.setId(rs.getInt("pom_id"));          
            unPompier.setNom(rs.getString("pom_nom"));       
            unPompier.setPrenom(rs.getString("pom_prenom")); 
            unPompier.setNumeroBip(rs.getInt("pom_numeroBip")); 
            unPompier.setStatut(rs.getString("pom_statut")); 
            
            java.sql.Date sqlDate = rs.getDate("pom_dateNaissance"); 
            if (sqlDate != null) {
                unPompier.setDateNaissance(sqlDate.toLocalDate());
            }
            
            Profession pro = new Profession();
            pro.setId(rs.getInt("pro_id"));
            pro.setLibelle(rs.getString("pro_libelle"));
            unPompier.setProfession(pro);
            
            Grades gra = new Grades();
            gra.setId(rs.getInt("gra_id"));
            gra.setLibelle(rs.getString("gra_libelle")); 
            unPompier.setGrades(gra);

            Caserne cas = new Caserne();
            cas.setId(rs.getInt("cas_id"));          
            cas.setNom(rs.getString("cas_nom"));       
            unPompier.setCaserne(cas);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return unPompier;
}

public static Pompier ajouterPompier(Connection cnx, Pompier p) {
    try {
        PreparedStatement requete = cnx.prepareStatement(
            "INSERT INTO pompier (pom_prenom, pom_nom, pom_statut, pom_numeroBip, pom_dateNaissance, cas_id, pro_id, gra_id) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
        requete.setString(1, p.getPrenom());
        requete.setString(2, p.getNom());
        requete.setString(3, p.getStatut());
        requete.setInt(4, p.getNumeroBip());
        requete.setDate(5, java.sql.Date.valueOf(p.getDateNaissance()));
        requete.setInt(6, p.getCaserne().getId());
        requete.setInt(7, p.getProfession().getId());
        requete.setInt(8, p.getGrades().getId());
        requete.executeUpdate();
        return p;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public static boolean modifierPompier(Connection cnx, Pompier p) {
    try {
        PreparedStatement requete = cnx.prepareStatement(
            "UPDATE pompier SET pom_nom=?, pom_prenom=?, pom_statut=?, " +
            "pom_numeroBip=?, pom_dateNaissance=?, cas_id=?, pro_id=?, gra_id=? " +
            "WHERE pom_id=?"
        );
        requete.setString(1, p.getNom());
        requete.setString(2, p.getPrenom());
        requete.setString(3, p.getStatut());
        requete.setInt(4, p.getNumeroBip());
        requete.setDate(5, java.sql.Date.valueOf(p.getDateNaissance()));
        requete.setInt(6, p.getCaserne().getId());
        requete.setInt(7, p.getProfession().getId());
        requete.setInt(8, p.getGrades().getId());
        requete.setInt(9, p.getId());
        requete.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


public static boolean supprimerPompier(Connection cnx, Pompier p) {

    String sql = "DELETE FROM pompier WHERE pom_id = ?";

    try (PreparedStatement requete = cnx.prepareStatement(sql)) {
        requete.setInt(1, p.getId());
        
        int nbLignesAffectees = requete.executeUpdate();
        
        // Retourne true si au moins une ligne a été supprimée
        return nbLignesAffectees > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}