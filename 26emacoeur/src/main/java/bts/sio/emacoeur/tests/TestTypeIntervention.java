/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.TypeIntervention;

/**
 *
 * @author ts1sio
 */
public class TestTypeIntervention {
     public static void main(String[] args) {
         
         TypeIntervention typeintervention1 = new TypeIntervention();
         typeintervention1.setId(1);
         typeintervention1.setLibelle("Incendie");
         
         System.out.println("Le type d'intervention comportant l'id " + typeintervention1.getId() + " a comme libelle " + typeintervention1.getLibelle());
    
}
}
