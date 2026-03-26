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
         
        TypeIntervention typeintervention2 = new TypeIntervention(5, "Malaise");

        Intervention i1 = new Intervention(66, LocalDate.of(2020, 05, 18));
        Intervention i2 = new Intervention(90, LocalDate.of(2019, 06, 30));

        // Lien côté TypeIntervention → Intervention
        typeintervention2.addUneIntervention(i1);
        typeintervention2.addUneIntervention(i2);

        // Lien côté Intervention → TypeIntervention ← ce qui manquait
        i1.setTypeintervention(typeintervention2);
        i2.setTypeintervention(typeintervention2);

        // Tu peux maintenant naviguer dans les 2 sens
        for (Intervention i : typeintervention2.getDesInterventions()) {
            System.out.println("* " + i.getId() 
                + " " + i.getDateIntervention() 
                + " | Type : " + i.getTypeintervention().getLibelle()); // ✅
        }
     }
}
