/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.form;

import bts.sio.emacoeur.model.Grades;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 *
 * @author jules
 */
public class FormGrades {

    private HashMap<String, String> erreurs = new HashMap<>();

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public Grades ajouterGrades(HttpServletRequest request) {
        Grades unGrade = new Grades();

        String libelle = request.getParameter("libelle");
        if (libelle == null || libelle.trim().isEmpty()) {
            erreurs.put("libelle", "Le libellé est obligatoire.");
        } else {
            unGrade.setLibelle(libelle.trim());
        }

        return unGrade;
    }
}