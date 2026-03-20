/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

/**
 *
 * @author ts1sio
 */
public class Caserne {
    
    private int id;
    private String nom;
    private String ville;
    private String cp;
    private String rue;

    public Caserne() {
    }

    public Caserne(int id, String nom, String ville, String cp, String rue) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.cp = cp;
        this.rue = rue;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public String getCp() {
        return cp;
    }

    public String getRue() {
        return rue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }
    
    
}
