/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author nathan
 */
public class Intervention {
    
    private int id;
    private LocalDate dateIntervention;
    private TypeIntervention typeintervention;
    private ArrayList<Pompier> lesPompiers;

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

    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }

    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }
    
    public void addUnPompier (Pompier unPompier){
        if (lesPompiers == null){
            lesPompiers = new ArrayList<>();
        }
        lesPompiers.add(unPompier);
    }
    
    
    
}
