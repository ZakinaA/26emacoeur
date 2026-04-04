/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.form;

import bts.sio.emacoeur.model.Caserne;
import bts.sio.emacoeur.model.Grades;
import bts.sio.emacoeur.model.Pompier;
import bts.sio.emacoeur.model.Profession;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class FormPompier {

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
            throw new Exception("Le nom doit contenir au moins 2 caractères.");
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if (prenom == null || prenom.length() < 2) {
            throw new Exception("Le prénom doit contenir au moins 2 caractères.");
        }
    }

    private void validationNumeroBip(String numeroBip) throws Exception {
        if (numeroBip == null) {
            throw new Exception("Le numéro de bip est obligatoire.");
        }
        try {
            Integer.parseInt(numeroBip);
        } catch (NumberFormatException e) {
            throw new Exception("Le numéro de bip doit être un nombre.");
        }
    }

    public Pompier ajouterPompier(HttpServletRequest request) {
        
    Pompier p = new Pompier();
    String nom = getDataForm(request, "nom");
    String prenom = getDataForm(request, "prenom");
    String statut = getDataForm(request, "statut");
    String numeroBip = getDataForm(request, "numerobip");
    String caserneId = getDataForm(request, "maison_id");
    String professionId = getDataForm(request, "pro_id");   
    String gradeId = getDataForm(request, "gra_id");         

    try { validationNom(nom); }
    catch (Exception e) { setErreur("nom", e.getMessage()); }
    try { validationPrenom(prenom); }
    catch (Exception e) { setErreur("prenom", e.getMessage()); }
    try { validationNumeroBip(numeroBip); }
    catch (Exception e) { setErreur("numerobip", e.getMessage()); }

    p.setNom(nom);
    p.setPrenom(prenom);
    p.setStatut(statut);
    if (numeroBip != null) p.setNumeroBip(Integer.parseInt(numeroBip));

    Caserne c = new Caserne();
    c.setId(Integer.parseInt(caserneId));
    p.setCaserne(c);

    // ← ajout
    Profession pro = new Profession();
    pro.setId(Integer.parseInt(professionId));
    p.setProfession(pro);

    // ← ajout
    Grades gra = new Grades();
    gra.setId(Integer.parseInt(gradeId));
    p.setGrades(gra);

    if (erreurs.isEmpty()) {
        resultat = "Succès de l'ajout.";
    } else {
        resultat = "Échec de l'ajout.";
    }
    return p;
}
}