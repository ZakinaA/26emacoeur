/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class Volontaire {
    
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int numeroBip;
    private ArrayList<Profession> desProfessions;

    public Volontaire() {
    }

    public Volontaire(int id, String nom, String prenom, LocalDate dateNaissance, int numeroBip) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.numeroBip = numeroBip;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public int getNumeroBip() {
        return numeroBip;
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

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNumeroBip(int numeroBip) {
        this.numeroBip = numeroBip;
    }

    public ArrayList<Profession> getDesProfessions() {
        return desProfessions;
    }

    public void setDesProfessions(ArrayList<Profession> desProfessions) {
        this.desProfessions = desProfessions;
    }
    
    public void addUneProfession( Profession uneProfession){
        if ( desProfessions == null ){
            desProfessions = new ArrayList<Profession>();
        }
        desProfessions.add(uneProfession);
    }
}
