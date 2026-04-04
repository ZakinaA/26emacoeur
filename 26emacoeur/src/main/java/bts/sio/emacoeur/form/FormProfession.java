/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.form;

import bts.sio.emacoeur.model.Profession;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 *
 * @author jules
 */

public class FormProfession {

    private HashMap<String, String> erreurs = new HashMap<>();

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public Profession ajouterProfession(HttpServletRequest request) {
        Profession uneProfession = new Profession();

        // Libelle
        String libelle = request.getParameter("libelle");
        if (libelle == null || libelle.trim().isEmpty()) {
            erreurs.put("libelle", "Le libellé est obligatoire.");
        } else {
            uneProfession.setLibelle(libelle.trim());
        }

        // Ville
        String ville = request.getParameter("ville");
        if (ville == null || ville.trim().isEmpty()) {
            erreurs.put("ville", "La ville est obligatoire.");
        } else {
            uneProfession.setVille(ville.trim());
        }

        return uneProfession;
    }
}