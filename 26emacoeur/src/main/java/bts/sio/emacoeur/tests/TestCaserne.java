package bts.sio.emacoeur.tests;

import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Engin;

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
    }
}