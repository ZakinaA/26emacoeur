/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Pompier;
import bts.sio.emacoeur.model.Profession;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestProfession {
    
    public static void main(String[] args) {

        Profession profession1 = new Profession(1, "Infirmier", "Paris");
        
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
        
        profession1.addUnPompier(pompier1);
        profession1.addUnPompier(pompier2);
   
        System.out.println("La profession n " + profession1.getId() 
                + " est " + profession1.getLibelle() 
                + " a " + profession1.getVille()
                + " possede ces pompiers :");
        
        for (Pompier e : profession1.getLesPompiers()){
        System.out.println(". " + e.getPrenom() + " " + e.getNom());
        }
    }
}
