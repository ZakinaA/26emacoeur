/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Caserne;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class DaoCaserne {
    
    Connection cnx = null;
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    public static ArrayList<Caserne> getLesCasernes(Connection cnx){ 
    
     ArrayList<Caserne> desCasernes = new ArrayList<Caserne>();
        try{

            requete=cnx.prepareStatement(" select cas_id as c_id, cas_nom as c_nom, cas_ville as c_ville, cas_cp as c_cp, cas_rue as c_rue \n"
            + "from caserne \n ");

            
            rs=requete.executeQuery();
            
            while(rs.next()){
                
                Caserne uneCaserne = new Caserne();
                uneCaserne.setId(rs.getInt("c_id"));
                uneCaserne.setNom(rs.getString("c_nom"));
                uneCaserne.setVille(rs.getString("c_ville"));
                uneCaserne.setCp(rs.getString("c_cp"));
                uneCaserne.setRue(rs.getString("c_rue"));
                
                desCasernes.add(uneCaserne);
                
  
            }
        }catch(SQLException e){
            
            e.printStackTrace();
            System.out.println("Erreur lors de l'etablissement de la connexion");
            
        }
        return desCasernes;
    }
        
    public static Caserne getCaserneById (Connection cnx, int idCaserne){
        
        Caserne uneCaserne = new Caserne();
        try
        {
            requete=cnx.prepareStatement(" select cas_id as c_id, cas_nom as c_nom, cas_ville as c_ville, cas_cp as c_cp, cas_rue as c_rue \n"
            + "from caserne \n " +
            "where cas_id");
            
            requete.setInt(1, idCaserne);
            
            rs=requete.executeQuery();
            
            if(rs.next()){
                
                uneCaserne.setId(rs.getInt("c_id"));
                uneCaserne.setNom(rs.getString("c_nom"));
                uneCaserne.setVille(rs.getString("c_ville"));
                uneCaserne.setCp(rs.getString("c_cp"));
                uneCaserne.setRue(rs.getString("c_rue"));
                
        }
    }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return uneCaserne;
    }
    
        
        
}
    

