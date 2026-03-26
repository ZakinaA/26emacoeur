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
public class Pompier {
    
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int numeroBip;
    private Grades grades;
    private Caserne caserne;
    private ArrayList<Intervention> lesInterventions;

    public Pompier() {
    }

    public Pompier(int id, String nom, String prenom, LocalDate dateNaissance, int numeroBip) {
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

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    public Caserne getCaserne() {
        return caserne;
    }

    public void setCaserne(Caserne caserne) {
        this.caserne = caserne;
    }

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    public void addUneIntervention (Intervention uneIntervention){
        if (lesInterventions == null){
            lesInterventions = new ArrayList<>();
        }
        lesInterventions.add(uneIntervention);
    }
    
    
    
    
    
}
