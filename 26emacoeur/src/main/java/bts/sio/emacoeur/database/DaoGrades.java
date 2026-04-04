/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Pompier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class DaoGrades {

    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static ArrayList<Grades> getLesGrades(Connection cnx) throws SQLException {
        ArrayList<Grades> lesGrades = new ArrayList<Grades>();
        try {
            requete = cnx.prepareStatement(
                "SELECT gra.gra_id, gra.gra_libelle FROM grades gra"
            );
            rs = requete.executeQuery();
            while (rs.next()) {
                Grades unGrade = new Grades();
                unGrade.setId(rs.getInt("gra_id"));
                unGrade.setLibelle(rs.getString("gra_libelle"));
                lesGrades.add(unGrade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesGrades;
    }

    public static Grades getGradeById(Connection cnx, int idGrade) {
        Grades unGrade = new Grades();
        try {
            requete = cnx.prepareStatement(
                "SELECT gra.gra_id, gra.gra_libelle, " +
                "pom.pom_id, pom.pom_nom, pom.pom_prenom, pom.pom_statut, pom.pom_numeroBip " +
                "FROM grades gra " +
                "LEFT JOIN pompier pom ON gra.gra_id = pom.gra_id " +
                "WHERE gra.gra_id = ?"
            );
            requete.setInt(1, idGrade);
            rs = requete.executeQuery();

            boolean firstRow = true;
            while (rs.next()) {
                if (firstRow) {
                    unGrade.setId(rs.getInt("gra_id"));
                    unGrade.setLibelle(rs.getString("gra_libelle"));
                    firstRow = false;
                }
                int pomId = rs.getInt("pom_id");
                if (!rs.wasNull()) {
                    Pompier unPompier = new Pompier();
                    unPompier.setId(pomId);
                    unPompier.setNom(rs.getString("pom_nom"));
                    unPompier.setPrenom(rs.getString("pom_prenom"));
                    unPompier.setStatut(rs.getString("pom_statut"));
                    unPompier.setNumeroBip(rs.getInt("pom_numeroBip"));
                    unGrade.addUnPompier(unPompier);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unGrade;
    }

    public static Grades ajouterGrade(Connection cnx, Grades g) {
        try {
            PreparedStatement requete = cnx.prepareStatement(
                "INSERT INTO grades (gra_libelle) VALUES (?)"
            );
            requete.setString(1, g.getLibelle());
            requete.executeUpdate();
            return g;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}