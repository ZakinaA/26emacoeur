/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Grades;

/**
 *
 * @author ts1sio
 */
public class TestGrades {
    public static void main(String[] args) {
    
    Grades grade1 = new Grades();
    grade1.setId(1);
    grade1.setLibelle("Sapeur");
    
    System.out.println("le grade comportant l'id " + grade1.getId() + " est le grade " + grade1.getLibelle());
            
}
}
