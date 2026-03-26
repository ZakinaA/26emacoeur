/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Profession;
import bts.sio.emacoeur.model.Volontaire;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestVolontaire {
    
    public static void main(String[] args) {

        Profession profession1 = new Profession(1, "Infirmier", "Paris");

        Volontaire vol1 = new Volontaire();
        vol1.setId(1);
        vol1.setNom("Dupont");
        vol1.setPrenom("Jean");
        vol1.setDateNaissance(LocalDate.of(1985, 6, 15));
        vol1.setNumeroBip(101);
        vol1.setProfession(profession1);

        Volontaire vol2 = new Volontaire();
        vol2.setId(2);
        vol2.setNom("Martin");
        vol2.setPrenom("Claire");
        vol2.setDateNaissance(LocalDate.of(1990, 9, 20));
        vol2.setNumeroBip(102);
        vol2.setProfession(profession1);

        System.out.println("Le volontaire " + vol1.getPrenom() 
                + " " + vol1.getNom() 
                + " a le numero bip n " + vol1.getNumeroBip() 
                + " et exerce la profession : " + vol1.getProfession().getLibelle()
                + " à " + vol1.getProfession().getVille());

        System.out.println("Le volontaire " + vol2.getPrenom() 
                + " " + vol2.getNom() 
                + " a le numero bip n " + vol2.getNumeroBip() 
                + " et exerce la profession : " + vol2.getProfession().getLibelle()
                + " à " + vol2.getProfession().getVille());
    }
}