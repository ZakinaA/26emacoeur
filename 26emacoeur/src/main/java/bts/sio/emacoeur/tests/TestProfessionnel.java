/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Professionnel;
import java.time.LocalDate;


/**
 *
 * @author natha
 */
public class TestProfessionnel {
    
    public static void main(String[] args) {
        
        Professionnel pro1 = new Professionnel();
        pro1.setId(1);
        pro1.setNom("Goerge");
        pro1.setPrenom("Pierre");
        pro1.setDateNaissance(LocalDate.of(1985,6,15));
        pro1.setIndiceTraitement("je sais pas ce que c'est");
        pro1.setNumeroBip(101);
        pro1.setDateObtentionIndice(LocalDate.of(1985,6,15));
        
       
        System.out.println(pro1.getId()+" "+pro1.getNom()+" "+pro1.getPrenom()+" "+pro1.getIndiceTraitement()+" "+pro1.getNumeroBip()+" "+pro1.getDateNaissance()+" "+pro1.getDateObtentionIndice());
    }
    
}
