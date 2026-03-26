package bts.sio.emacoeur.tests;
import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Engin;

public class TestEngin {
    
    public static void main(String[] args) {
        
        Engin en = new Engin();
        en.setId(1);
        en.setType("Camion");
        
        Engin en2 = new Engin(2, "Voiture");
        
        System.out.println(en.getId()+" "+en.getType());
        System.out.println(en2.getId()+" "+en2.getType());
        
        Caserne c1 = new Caserne(1, "Yvetot", "Yvetot", "76190", "1 rue de la paix");
        Caserne c2 = new Caserne(2, "Caen", "Caen", "14000", "5 rue de la mer");
        
        en.addUneCaserne(c1);
        en.addUneCaserne(c2);
        c1.addUnEngin(en);
        c2.addUnEngin(en);
        
        System.out.println("\n=== Casernes de l'engin " + en.getId() + " ===");
        for (Caserne c : en.getDesCasernes()) {
            System.out.println("  - " + c.getNom() + " | " + c.getVille());
        }
        
        System.out.println("\n=== Engins de la caserne " + c1.getNom() + " ===");
        for (Engin e : c1.getDesEngins()) {
            System.out.println("  - Engin " + e.getId() + " | " + e.getType());
        }
    }
}