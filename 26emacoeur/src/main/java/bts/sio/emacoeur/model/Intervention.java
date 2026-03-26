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

    public Intervention() {
    }

    public Intervention(int id, LocalDate dateIntervention) {
        this.id = id;
        this.dateIntervention = dateIntervention;
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
