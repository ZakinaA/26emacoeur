/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Engin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nathan
 */
public class DaoEngin {
    
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    public static ArrayList<Engin> getLesEngins(Connection cnx) {
        
        ArrayList<Engin> desEngins =  new ArrayList<Engin>();
        try {
            requete = cnx.prepareStatement("SELECT eng_id as e_id, eng_type as e_type \n " +
                            "FROM engin; \n");
            
            rs = requete.executeQuery();
            
            while(rs.next()){
                Engin unEngin = new Engin();
                unEngin.setId(rs.getInt("e_id"));
                unEngin.setType(rs.getString("e_type"));
                
                desEngins.add(unEngin);
                
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'execution de la requete");
        }
        return desEngins;
        
    } 
    
    public static Engin getEnginById(Connection cnx, int idEngin){
        
        Engin unEngin = new Engin();
        
        try{
            
            requete=cnx.prepareStatement("SELECT eng_id as e_id, eng_type as e_type \n " +
                            "FROM engin; \n");
            
            requete.setInt(1,idEngin);
            rs=requete.executeQuery();
            
            if( rs.next() ){
                unEngin.setId(rs.getInt("e_id"));
                unEngin.setType(rs.getString("e_type"));
            }
            
        }
        catch( SQLException e ){
            
            e.printStackTrace();
        }
        return unEngin;
        
    }
    
    public static Engin ajouterEngin(Connection cnx, Engin e) {
        try {
            PreparedStatement requete = cnx.prepareStatement(
                "INSERT INTO engin (eng_type) VALUES (?)"
            );
            requete.setString(1, e.getType());
            requete.executeUpdate();
            return e;
        } catch (SQLException s) {
            s.printStackTrace();
            return null;
        }
    }
}
