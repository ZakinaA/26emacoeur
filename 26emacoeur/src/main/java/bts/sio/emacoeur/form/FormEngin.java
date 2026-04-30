/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bts.sio.emacoeur.form;

import bts.sio.emacoeur.model.Engin;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 *
 * @author ts1sio
 */
public class FormEngin {

    private HashMap<String, String> erreurs = new HashMap<>();

    public HashMap<String, String> getErreurs() {
        return erreurs;
    }

    public Engin ajouterEngin(HttpServletRequest request) {
        Engin unEngin = new Engin();

        String type = request.getParameter("libelle");
        if (type == null || type.trim().isEmpty()) {
            erreurs.put("type", "Le type est obligatoire.");
        } else {
            unEngin.setType(type.trim());
        }

        return unEngin;
    }
}