package bts.sio.emacoeur.database;

import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.model.TypeIntervention;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoIntervention {
    
    static PreparedStatement requete = null;
    static ResultSet rs = null;
    
    public static ArrayList<Intervention> getLesInterventions(Connection cnx) { 
        
        ArrayList<Intervention> desInters = new ArrayList<Intervention>();
        try {
            requete = cnx.prepareStatement("select intervention.int_id as i_id, int_dateIntervention as i_dateInter, typ_id as ty_id, typ_libelle as ty_libelle \n"
                    + "from intervention \n"
                    + "join type_intervention \n"
                    + "on intervention.int_id = type_intervention.int_id;");
            
            rs = requete.executeQuery();
            
            while(rs.next()){
                Intervention uneInter = new Intervention();
                uneInter.setId(rs.getInt("i_id"));
                
                Date sqlDateIntervention = rs.getDate("i_dateInter");
                if (sqlDateIntervention != null) {
                    uneInter.setDateIntervention(sqlDateIntervention.toLocalDate());
                }
                
                TypeIntervention typeInter = new TypeIntervention();
                typeInter.setId(rs.getInt("ty_id"));
                typeInter.setLibelle(rs.getString("ty_libelle"));
                
                uneInter.setTypeintervention(typeInter);
                
                desInters.add(uneInter);
            }
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'execution de la requete");
        }
        return desInters;
    }
}