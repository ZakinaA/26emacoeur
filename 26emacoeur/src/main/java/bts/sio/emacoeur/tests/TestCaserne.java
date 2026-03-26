package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Engin;
import bts.sio.emacoeur.model.Pompier;
import java.time.LocalDate;

public class TestCaserne {
    
    public static void main(String[] args) {
        
        // Ta caserne existante
        Caserne cas = new Caserne();
        cas.setId(1);
        cas.setNom("Tamalou");
        cas.setRue("boulevard des pommes");
        cas.setVille("Caen");
        cas.setCp("14000");
        
        // Créer des engins
        Engin e1 = new Engin(1, "Camion citerne");
        Engin e2 = new Engin(2, "Échelle");
        
        // Créer des pompier
        Pompier pompier1 = new Pompier();
        pompier1.setId(1);
        pompier1.setNom("Dupont");
        pompier1.setPrenom("Jean");
        pompier1.setDateNaissance(LocalDate.of(1985,6,15));
        pompier1.setNumeroBip(101);
        
        Pompier pompier2 = new Pompier();
         pompier2.setId(2);
         pompier2.setNom("Martin");
         pompier2.setPrenom("Claire");
         pompier2.setDateNaissance(LocalDate.of(1990,9,20));
         pompier2.setNumeroBip(102);
         
        //lien entre pompier et caserne
        cas.addUnPompier(pompier1);
        cas.addUnPompier(pompier2);

        
        // Lien dans les 2 sens
        cas.addUnEngin(e1);
        cas.addUnEngin(e2);
        e1.addUneCaserne(cas);
        e2.addUneCaserne(cas);
        
        // Affichage caserne
        System.out.println("=== Caserne ===");
        System.out.println(cas.getNom() + " " + cas.getVille() + " " + cas.getCp() + " " + cas.getRue());
        
        // Affichage des engins de la caserne
        System.out.println("\n=== Engins de la caserne " + cas.getNom() + " ===");
        for (Engin e : cas.getDesEngins()) {
            System.out.println("  - Engin " + e.getId() + " | " + e.getType());
        }
        
        // Affichage des casernes de l'engin (sens inverse)
        System.out.println("\n=== Casernes de l'engin " + e1.getId() + " ===");
        for (Caserne c : e1.getDesCasernes()) {
            System.out.println("  - " + c.getNom() + " | " + c.getVille());
        }
        
        System.out.println("\nLa " + cas.getNom() + " a pour Pompiers : ");
        
        for (Pompier p : cas.getLesPompiers()){
        System.out.println(". " + p.getPrenom() + " " + p.getNom());
    }
        
    }
}