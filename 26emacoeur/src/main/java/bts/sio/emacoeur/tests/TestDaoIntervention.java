package bts.sio.emacoeur.tests;

//import bts.sio.emacoeur.database.ConnexionBdd;
import bts.sio.emacoeur.database.DaoIntervention;
import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.database.ConnexionBdd;
import java.sql.Connection;
import java.util.ArrayList;

public class TestDaoIntervention {

    public static void main(String[] args) {
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        
        ArrayList<Intervention> desInters = DaoIntervention.getLesInterventions(cnx);
        
        for (Intervention uneInter : desInters) {
            System.out.println("ID Intervention : " + uneInter.getId());
            System.out.println("Date : " + uneInter.getDateIntervention());               
            System.out.println("ID Type : " + uneInter.getTypeintervention().getId());
            System.out.println("Libellé Type : " + uneInter.getTypeintervention().getLibelle());
            System.out.println("----------------------------------------");
        }
        
        ConnexionBdd.fermerConnexion(cnx);
    }
}