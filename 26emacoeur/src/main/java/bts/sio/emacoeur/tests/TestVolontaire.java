/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Volontaire;
import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class TestVolontaire {
    public static void main (String[] args){
        
        Volontaire vol1 = new Volontaire();
        vol1.setId(1);
        vol1.setNom("Dupont");
        vol1.setPrenom("Jean");
        vol1.setDateNaissance(LocalDate.of(1985,6,15));
        vol1.setNumeroBip(101);
        
        System.out.println(" Le volontaire " + vol1.getPrenom()+ " " + vol1.getNom() + " a le numéro bip n°" +vol1.getNumeroBip());
    }
}
