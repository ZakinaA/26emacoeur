/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class TypeIntervention {
    
    private int id;
    private String libelle;
    private ArrayList<Intervention> desInterventions;
    private ArrayList<Engin> desEngins;
    

    public TypeIntervention() {
    }

    public TypeIntervention(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public TypeIntervention(int id, String libelle, ArrayList<Intervention> desInterventions, ArrayList<Engin> desEngins) {
        this.id = id;
        this.libelle = libelle;
        this.desInterventions = desInterventions;
        this.desEngins = desEngins;
    }

    public ArrayList<Engin> getDesEngins() {
        return desEngins;
    }

    public void setDesEngins(ArrayList<Engin> desEngins) {
        this.desEngins = desEngins;
    }
    
    public void addDesEngins (Engin unEngin) {
        if (desEngins == null) {
            desEngins = new ArrayList<Engin>();
        }
        desEngins.add(unEngin);
    }

    public ArrayList<Intervention> getDesInterventions() {
        return desInterventions;
    }

    public void setDesInterventions(ArrayList<Intervention> desInterventions) {
        this.desInterventions = desInterventions;
    }
    
    public void addUneIntervention( Intervention uneIntervention){
        if ( desInterventions == null ){
            desInterventions = new ArrayList<Intervention>();
        }
        desInterventions.add(uneIntervention);
        
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
