/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Caserne;

/**
 *
 * @author ts1sio
 */
public class TestCaserne {
    
    public static void main(String[] args) {
        
        Caserne cas = new Caserne();
        cas.setId(0);
        cas.setNom("Tamalou");
        cas.setRue("boulevard des pommes");
        cas.setVille("Caen");
        cas.setCp("14000");
        
        System.out.println(cas.getNom()+" "+cas.getVille()+" "+cas.getCp()+" "+cas.getRue());
        
    }
    
}
