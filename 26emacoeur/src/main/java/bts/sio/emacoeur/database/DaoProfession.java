/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Pompier;
import bts.sio.emacoeur.model.Profession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class DaoProfession {

    Connection cnx = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;

    public static ArrayList<Profession> getLesProfessions(Connection cnx) throws SQLException {

        ArrayList<Profession> lesProfessions = new ArrayList<Profession>();
        try {
            requete = cnx.prepareStatement(
                    "SELECT pro.pro_id, pro.pro_libelle, pro.pro_ville " +
                    "FROM profession pro"
            );

            rs = requete.executeQuery();

            while (rs.next()) {
                Profession uneProfession = new Profession();
                uneProfession.setId(rs.getInt("pro_id"));
                uneProfession.setLibelle(rs.getString("pro_libelle"));
                uneProfession.setVille(rs.getString("pro_ville"));

                lesProfessions.add(uneProfession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesProfessions;
    }

    public static Profession getProfessionById(Connection cnx, int idProfession) {
        Profession uneProfession = new Profession();
        try {
            requete = cnx.prepareStatement(
                    "SELECT pro.pro_id, pro.pro_libelle, pro.pro_ville, " +
                    "pom.pom_id, pom.pom_nom, pom.pom_prenom, pom.pom_statut, pom.pom_numeroBip " +
                    "FROM profession pro " +
                    "LEFT JOIN pompier pom ON pro.pro_id = pom.pro_id " +
                    "WHERE pro.pro_id = ?"
            );
            requete.setInt(1, idProfession);
            rs = requete.executeQuery();

            boolean firstRow = true;
            while (rs.next()) {
                // On remplit la profession une seule fois
                if (firstRow) {
                    uneProfession.setId(rs.getInt("pro_id"));
                    uneProfession.setLibelle(rs.getString("pro_libelle"));
                    uneProfession.setVille(rs.getString("pro_ville"));
                    firstRow = false;
                }

                // On ajoute chaque pompier rattaché à la profession
                int pomId = rs.getInt("pom_id");
                if (!rs.wasNull()) {
                    Pompier unPompier = new Pompier();
                    unPompier.setId(pomId);
                    unPompier.setNom(rs.getString("pom_nom"));
                    unPompier.setPrenom(rs.getString("pom_prenom"));
                    unPompier.setStatut(rs.getString("pom_statut"));
                    unPompier.setNumeroBip(rs.getInt("pom_numeroBip"));
                    uneProfession.addUnPompier(unPompier);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uneProfession;
    }

    public static Profession ajouterProfession(Connection cnx, Profession p) {
        try {
            PreparedStatement requete = cnx.prepareStatement(
                    "INSERT INTO profession (pro_libelle, pro_ville) " +
                    "VALUES (?, ?)"
            );
            requete.setString(1, p.getLibelle());
            requete.setString(2, p.getVille());
            requete.executeUpdate();
            return p; // succès
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // échec
        }
    }
}