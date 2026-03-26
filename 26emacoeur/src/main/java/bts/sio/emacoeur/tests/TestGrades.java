/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Pompier;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestGrades {
    public static void main(String[] args) {
    
    Grades grade1 = new Grades();
    grade1.setId(1);
    grade1.setLibelle("Sapeur");
    
      Pompier pompier1 = new Pompier();
        pompier1.setId(1);
        pompier1.setNom("Dupont");
        pompier1.setPrenom("Jean");
        pompier1.setDateNaissance(LocalDate.of(1985,6,15));
        pompier1.setNumeroBip(101);
        
        Pompier pompier2 = new Pompier();
         pompier2.setId(2);
         pompier2.setNom("Martin");
         pompier2.setPrenom("Claire");
         pompier2.setDateNaissance(LocalDate.of(1990,9,20));
         pompier2.setNumeroBip(102);
        
        grade1.addUnPompier(pompier1);
        grade1.addUnPompier(pompier2);
    
    System.out.println("le grade comportant l'id " + grade1.getId() + " est le grade " + grade1.getLibelle()+" ce grade comprend les pompiers : ");
    
    for (Pompier e : grade1.getLesPompiers()){
        System.out.println(". " + e.getPrenom() + " " + e.getNom());
    }
    
            
}
}
