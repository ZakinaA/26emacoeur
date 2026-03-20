/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Engin;

/**
 *
 * @author 
 */
public class TestEngin {
    
    public static void main(String[] args) {
        
        Engin en = new Engin();
        en.setId(1);
        en.setType("Camion");
        
        Engin en2 = new Engin(2, "Voiture");
        
        System.out.println(en.getId()+" "+en.getType());
        System.out.println(en2.getId()+" "+en2.getType());
        
    }
    
}
