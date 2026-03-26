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
public class TestPompier {
    public static void main(String[] args) {
        
        Pompier pompier1 = new Pompier();
        pompier1.setId(1);
        pompier1.setNom("Dupont");
        pompier1.setPrenom("Jean");
        pompier1.setDateNaissance(LocalDate.of(1985,6,15));
        pompier1.setNumeroBip(101);
        
        Grades unGrades = new Grades(4,"Caporal");
        
        pompier1.setGrades(unGrades);
        
        
        System.out.println(" Le pompier " + pompier1.getPrenom()+ " " + pompier1.getNom() + " a le numéro bip n°" +pompier1.getNumeroBip() +" dont le grade est " + pompier1.getGrades().getLibelle());
    
}
}