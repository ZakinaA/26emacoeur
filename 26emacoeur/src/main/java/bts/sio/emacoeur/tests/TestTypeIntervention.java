package bts.sio.emacoeur.tests;
import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.model.TypeIntervention;
import java.time.LocalDate;

public class TestTypeIntervention {
    
    public static void main(String[] args) {
        
        TypeIntervention typeintervention2 = new TypeIntervention(5, "Malaise");
        Intervention i1 = new Intervention(66, LocalDate.of(2020, 05, 18));
        Intervention i2 = new Intervention(90, LocalDate.of(2019, 06, 30));
        
        typeintervention2.addUneIntervention(i1);
        typeintervention2.addUneIntervention(i2);
        
        i1.setTypeintervention(typeintervention2);
        i2.setTypeintervention(typeintervention2);
        
        for (Intervention i : typeintervention2.getDesInterventions()) {
            System.out.println("* " + i.getId() 
                + " " + i.getDateIntervention() 
                + " | Type : " + i.getTypeintervention().getLibelle());
        }
        
        TypeIntervention typeintervention1 = new TypeIntervention(1, "Incendie");
        Intervention i3 = new Intervention(10, LocalDate.of(2025, 01, 15));
        
        typeintervention1.addUneIntervention(i3);
        i3.setTypeintervention(typeintervention1);
        
        System.out.println("\n=== Depuis l'intervention ===");
        System.out.println("Intervention " + i3.getId() 
            + " le " + i3.getDateIntervention() 
            + " | Type : " + i3.getTypeintervention().getLibelle());
    }
}