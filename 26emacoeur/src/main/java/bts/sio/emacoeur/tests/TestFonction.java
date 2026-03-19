/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Fonction;

/**
 *
 * @author ts1sio
 */
public class TestFonction {
    public static void main(String[] args){
    
        Fonction fonction = new Fonction();
        
        fonction.setId(1);
        fonction.setLibelle("Conducteur");
        
        Fonction fonction1 = new Fonction(2,"Chef d'agrès");
        
        System.out.println("la fonction numero" + fonction.getId() + " a pour libelle : " + fonction.getLibelle());
        System.out.println("la fonction numero" + fonction1.getId() + " a pour libelle : " + fonction1.getLibelle());
    }
    
}
