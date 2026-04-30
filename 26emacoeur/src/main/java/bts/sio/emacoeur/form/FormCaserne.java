/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.form;

import bts.sio.emacoeur.model.Caserne;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ts1sio
 */
public class FormCaserne {
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<>();

    public String getResultat() { return resultat; }
    public Map<String, String> getErreurs() { return erreurs; }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private static String getDataForm(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        }
        return valeur.trim();
    }

    private void validationNom(String nom) throws Exception {
        if (nom == null || nom.length() < 2) {
            throw new Exception("Le nom de la caserne doit contenir au moins 2 caractères.");
        }
    }

    private void validationVille(String ville) throws Exception {
        if (ville == null || ville.length() < 2) {
            throw new Exception("La ville doit contenir au moins 2 caractères.");
        }
    }

    private void validationCp(String cp) throws Exception {
        if (cp == null) {
            throw new Exception("Le code postal est obligatoire.");
        }
        try {
            Integer.parseInt(cp);
        } catch (NumberFormatException e) {
            throw new Exception("Le code postal doit être composé uniquement de chiffres.");
        }
        if (cp.length() != 5) {
            throw new Exception("Le code postal doit contenir exactement 5 chiffres.");
        }
    }

    private void validationRue(String rue) throws Exception {
        if (rue == null || rue.length() < 5) {
            throw new Exception("La rue doit contenir au moins 5 caractères.");
        }
    }

    public Caserne ajouterCaserne(HttpServletRequest request) {
        
        Caserne c = new Caserne();
        
        // Récupération des données du formulaire
        String nom = getDataForm(request, "nom");
        String ville = getDataForm(request, "ville");
        String cp = getDataForm(request, "cp");
        String rue = getDataForm(request, "rue");

        // Validations
        try { validationNom(nom); }
        catch (Exception e) { setErreur("nom", e.getMessage()); }
        
        try { validationVille(ville); }
        catch (Exception e) { setErreur("ville", e.getMessage()); }
        
        try { validationCp(cp); }
        catch (Exception e) { setErreur("cp", e.getMessage()); }
        
        try { validationRue(rue); }
        catch (Exception e) { setErreur("rue", e.getMessage()); }

        // Hydratation de l'objet Caserne
        c.setNom(nom);
        c.setVille(ville);
        c.setCp(cp);
        c.setRue(rue);

        // Détermination du résultat final
        if (erreurs.isEmpty()) {
            resultat = "Succès de l'ajout de la caserne.";
        } else {
            resultat = "Échec de l'ajout de la caserne.";
        }
        
        return c;
    }
}
    

