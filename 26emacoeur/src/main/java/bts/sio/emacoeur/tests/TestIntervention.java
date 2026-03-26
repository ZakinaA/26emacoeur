/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Intervention;
import java.time.LocalDate;

/**
 *
 * @author nathan
 */
public class TestIntervention {
    
    public static void main(String[] args) {
        
        Intervention inter = new Intervention();
        
        inter.setId(1);
        inter.setDateIntervention(LocalDate.of(2026,02, 16));
        
        System.out.println("L'intervention "+inter.getId()+" a eu lieu le "+inter.getDateIntervention());
        
    }
}
