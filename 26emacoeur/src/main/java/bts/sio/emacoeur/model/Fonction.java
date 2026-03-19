/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

/**
 *
 * @author ts1sio
 */
public class Fonction {
    private int id;
    private String libelle; 

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

    public Fonction() {
    }

    public Fonction(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
}
