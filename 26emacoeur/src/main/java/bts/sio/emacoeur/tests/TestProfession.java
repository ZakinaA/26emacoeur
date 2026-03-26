/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Profession;

/**
 *
 * @author ts1sio
 */
public class TestProfession {
    public static void main(String[] args) {
    
    Profession profession1 = new Profession();
    profession1.setId(1);
    profession1.setLibelle("infermier");
    profession1.setVille("Paris");
    
    System.out.println("La profession n°" + profession1.getId() + " est " + profession1.getLibelle() + " et se trouve " + profession1.getVille() );
    
    }
}
