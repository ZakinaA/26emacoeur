/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.model.TypeIntervention;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestTypeIntervention {
     public static void main(String[] args) {
         
         TypeIntervention typeintervention1 = new TypeIntervention();
         typeintervention1.setId(1);
         typeintervention1.setLibelle("Incendie");
         
         Intervention inter1 = new Intervention(1, LocalDate.of(2026, 03, 22));
         
         
         TypeIntervention typeintervention2 = new TypeIntervention(5, "Malaise");
         
         Intervention i1 = new Intervention(66, LocalDate.of(2020, 05, 18));
         Intervention i2 = new Intervention(90, LocalDate.of(2019,06,30));
         
         typeintervention2.addUneIntervention(i1);
         typeintervention2.addUneIntervention(i2);
         
         System.out.println("Le type d'intervention comportant l'id " + typeintervention1.getId() + " a comme libelle " + typeintervention1.getLibelle());
         
         for (Intervention i : typeintervention2.getDesInterventions()){
             System.out.println("* "+i.getId()+" "+i.getDateIntervention());
             
         }
    }
}
