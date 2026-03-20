/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.TypeIntervention;
import org.w3c.dom.TypeInfo;

/**
 *
 * @author natha
 */
public class TestTypeIntervention {
    
    public static void main(String[] args) {
        
        TypeIntervention ty = new TypeIntervention();
        ty.setId(1);
        ty.setLibelle("Feu de foret");
        
        TypeIntervention ty2 = new TypeIntervention(2, "Malaise");
                
        System.out.println(ty.getId()+" "+ty.getLibelle());
        System.out.println(ty2.getId()+" "+ty2.getLibelle());
        
    }
}
