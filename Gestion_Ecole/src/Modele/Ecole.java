/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class Ecole {
    private HashMap<Integer, Eleve> eleves;
    private HashMap<Integer, Enseignant> profs;
    private HashMap<Integer, Directeur> directeurs;

    public Ecole() {
        
        DAO<Eleve> eleveDAO = DAOFactory.getEleveDAO();
        DAO<Enseignant> enseignantDAO = DAOFactory.getEnseignantDAO();
        DAO<Directeur> directeurDAO = DAOFactory.getDirecteurDAO();
        
        this.eleves = new HashMap<>(eleveDAO.getTable()); // Récupère les élèves
        this.profs = new HashMap<>(enseignantDAO.getTable()); // Récupère les profs
        this.directeurs = new HashMap<>(directeurDAO.getTable()); // Récupère les directeurs
        
        
    }
    
    /**
     *
     * @return la hashmap d'élèves
     */
    public HashMap<Integer, Eleve> getEleves() { return this.eleves; }
    public HashMap<Integer, Enseignant> getEnseignants() { return this.profs; }
    public HashMap<Integer, Directeur> getDirecteurs() { return this.directeurs; }
}
