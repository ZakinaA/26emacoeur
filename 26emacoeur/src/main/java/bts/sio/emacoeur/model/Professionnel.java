/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.util.Date;

/**
 *
 * @author natha
 */
public class Professionnel {
        
        private int id;
        private String nom;
        private String prenom;
        private Date dateNaissance; 
        private int numeroBip;
        
        private String indiceTraitement;
        private Date dateObtentionIndice;

    public Professionnel() {
    }

    public Professionnel(int id, String nom, String prenom, Date dateNaissance, int numeroBip, String indiceTraitement, Date dateObtentionIndice) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroBip = numeroBip;
        this.indiceTraitement = indiceTraitement;
        this.dateObtentionIndice = dateObtentionIndice;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public int getNumeroBip() {
        return numeroBip;
    }

    public String getIndiceTraitement() {
        return indiceTraitement;
    }

    public Date getDateObtentionIndice() {
        return dateObtentionIndice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumeroBip(int numeroBip) {
        this.numeroBip = numeroBip;
    }

    public void setIndiceTraitement(String indiceTraitement) {
        this.indiceTraitement = indiceTraitement;
    }

    public void setDateObtentionIndice(Date dateObtentionIndice) {
        this.dateObtentionIndice = dateObtentionIndice;
    }

}
