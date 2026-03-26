/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Engin {
    
    private int id; 
    private String type;
    private ArrayList<Caserne> desCasernes;
    private ArrayList<TypeIntervention> desTypeInterventions;
    
    public Engin(int id,String type) {
        this.id = id;
        this.type = type;
    }
    
    public Engin(){
        
    }

    public Engin(int id, String type, ArrayList<Caserne> desCasernes, ArrayList<TypeIntervention> desTypeInterventions) {
        this.id = id;
        this.type = type;
        this.desCasernes = desCasernes;
        this.desTypeInterventions = desTypeInterventions;
    }

    public ArrayList<TypeIntervention> getDesTypeInterventions() {
        return desTypeInterventions;
    }

    public void setDesTypeInterventions(ArrayList<TypeIntervention> desTypeInterventions) {
        this.desTypeInterventions = desTypeInterventions;
    }
    
    public void addUnTypeIntervention (TypeIntervention unTypeInter){
        if (desTypeInterventions == null) {
            desTypeInterventions = new ArrayList<TypeIntervention>();
        }
        desTypeInterventions.add(unTypeInter);
    }

    public ArrayList<Caserne> getDesCasernes() {
        return desCasernes;
    }

    public void setDesCasernes(ArrayList<Caserne> desCasernes) {
        this.desCasernes = desCasernes;
    }
    
    public void addUneCaserne (Caserne uneCaserne) {
        if (desCasernes == null) {
            desCasernes = new ArrayList<Caserne>();
        }
        desCasernes.add(uneCaserne);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
