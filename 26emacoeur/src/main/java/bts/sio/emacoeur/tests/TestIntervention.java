package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.model.TypeIntervention;
import java.time.LocalDate;

public class TestIntervention {
    
    public static void main(String[] args) {
        
        // Créer d'abord le TypeIntervention
        TypeIntervention type = new TypeIntervention();
        type.setId(1);
        type.setLibelle("Maintenance");
        
        // Créer l'Intervention et lui assigner son type
        Intervention inter = new Intervention();
        inter.setId(1);
        inter.setDateIntervention(LocalDate.of(2026, 02, 16));
        inter.setTypeintervention(type); // ← c'était ça qui manquait !
        
        System.out.println("L'intervention " + inter.getId() 
            + " a eu lieu le " + inter.getDateIntervention() 
            + " " + inter.getTypeintervention().getLibelle());
    }
}