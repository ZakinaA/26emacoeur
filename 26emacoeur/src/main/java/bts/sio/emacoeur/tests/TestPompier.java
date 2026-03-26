/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Intervention;
import bts.sio.emacoeur.model.Pompier;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestPompier {
    public static void main(String[] args) {
        
        Pompier pompier1 = new Pompier();
        pompier1.setId(1);
        pompier1.setNom("Dupont");
        pompier1.setPrenom("Jean");
        pompier1.setDateNaissance(LocalDate.of(1985,6,15));
        pompier1.setNumeroBip(101);
        
        //crée un grade       
        Grades unGrades = new Grades(4,"Caporal");
        Caserne uneCaserne = new Caserne(1,"Caserne Centrale","Paris","75001","Rue de Rivoli");
        
        //crée des intervention
        Intervention i1 = new Intervention(1, LocalDate.of(2024, 01, 10));
        Intervention i2 = new Intervention(2, LocalDate.of(2024, 02, 15));
        
        // Lien dans les 2 sens
        pompier1.addUneIntervention(i1);
        pompier1.addUneIntervention(i2);
        i1.addUnPompier(pompier1);
        i2.addUnPompier(pompier1);
        
        pompier1.setGrades(unGrades);
        pompier1.setCaserne(uneCaserne);
        
         // Affichage des pompier de l'intervention
        System.out.println("\n=== pompier de l'intervention " + i1.getId() + " ===");
        for (Pompier p : i1.getLesPompiers()) {
            System.out.println("  - Pompiers " + p.getPrenom() + " | " + p.getNom());
        }
        
        // Affichage des intervention des pompier (sens inverse)
        System.out.println("\n=== interventions du pompier " + pompier1.getPrenom() + " " + pompier1.getNom() +" ===");
        for (Intervention i : pompier1.getLesInterventions()) {
            System.out.println("  - " + i.getId() + " | " + i.getDateIntervention());
        }
        
        
        System.out.println(" Le pompier " + pompier1.getPrenom()+ " " + pompier1.getNom() + " a le numéro bip n°" +pompier1.getNumeroBip() +" dont le grade est " + pompier1.getGrades().getLibelle()
        + " sa caserne est la " + pompier1.getCaserne().getNom() +" situé dans la ville de " + pompier1.getCaserne().getVille());
    
}
}