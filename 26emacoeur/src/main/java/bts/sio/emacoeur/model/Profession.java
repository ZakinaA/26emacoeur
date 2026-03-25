/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

/**
 *
 * @author ts1sio
 */
public class Profession {
    private int id;
    private String libelle;
    private String ville;

    public Profession() {
    }

    public Profession(int id, String libelle, String ville) {
        this.id = id;
        this.libelle = libelle;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getVille() {
        return ville;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
}
