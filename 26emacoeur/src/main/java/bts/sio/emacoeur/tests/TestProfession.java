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
public class TestProfession {
    
    public static void main(String[] args) {

        Profession profession1 = new Profession(1, "Infirmier", "Paris");

        Volontaire vol1 = new Volontaire(1, "Dupont", "Jean", LocalDate.of(1985, 6, 15), 101);
        vol1.setProfession(profession1);

        Volontaire vol2 = new Volontaire(2, "Martin", "Claire", LocalDate.of(1990, 9, 20), 102);
        vol2.setProfession(profession1);

        profession1.addUnVolontaire(vol1);
        profession1.addUnVolontaire(vol2);

        System.out.println("La profession n " + profession1.getId() 
                + " est " + profession1.getLibelle() 
                + " a " + profession1.getVille()
                + " possede ces volontaires :");

        for (Volontaire v : profession1.getDesVolontaires()) {
            System.out.println(" Volontaire : " + v.getPrenom() 
                    + " " + v.getNom() 
                    + ", bip n " + v.getNumeroBip());
        }
    }
}
