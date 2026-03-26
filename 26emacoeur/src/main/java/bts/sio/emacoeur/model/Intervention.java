/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.time.LocalDate;

/**
 *
 * @author nathan
 */
public class Intervention {
    
    private int id;
    private LocalDate dateIntervention;
    private TypeIntervention typeintervention;

    public Intervention() {
    }

    public Intervention(int id, LocalDate dateIntervention) {
        this.id = id;
        this.dateIntervention = dateIntervention;
    }

    public Intervention(int id, LocalDate dateIntervention, TypeIntervention typeintervention) {
        this.id = id;
        this.dateIntervention = dateIntervention;
        this.typeintervention = typeintervention;
    }

    public TypeIntervention getTypeintervention() {
        return typeintervention;
    }

    public void setTypeintervention(TypeIntervention typeintervention) {
        this.typeintervention = typeintervention;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDateIntervention() {
        return dateIntervention;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateIntervention(LocalDate dateIntervention) {
        this.dateIntervention = dateIntervention;
    }
    
    
    
    
    
}
