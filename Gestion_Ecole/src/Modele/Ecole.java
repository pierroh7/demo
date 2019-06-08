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
    private HashMap<Integer, Discipline> disciplines;
    private HashMap<Integer, Niveau> niveaux;
    private HashMap<Integer, Annee> annees;

    public Ecole() {
        
        DAO<Eleve> eleveDAO = DAOFactory.getEleveDAO();
        DAO<Enseignant> enseignantDAO = DAOFactory.getEnseignantDAO();
        DAO<Directeur> directeurDAO = DAOFactory.getDirecteurDAO();
        DAO<Discipline> disciplineDAO = DAOFactory.getDisciplineDAO();
        DAO<Niveau> niveauDAO = DAOFactory.getNiveauDAO();
        DAO<Annee> anneeDAO = DAOFactory.getAnneeDAO();
        
        this.eleves = new HashMap<>(eleveDAO.getTable()); // Récupère les élèves
        this.profs = new HashMap<>(enseignantDAO.getTable()); // Récupère les profs
        this.directeurs = new HashMap<>(directeurDAO.getTable()); // Récupère les directeurs
        this.disciplines = new HashMap<>(disciplineDAO.getTable()); // Récupère les disciplines
        this.niveaux = new HashMap<>(niveauDAO.getTable()); // Récupère les niveaux
        this.annees = new HashMap<>(anneeDAO.getTable());    
    }
    
    public HashMap<Integer, Eleve> getEleves() { return this.eleves; }
    public HashMap<Integer, Enseignant> getEnseignants() { return this.profs; }
    public HashMap<Integer, Directeur> getDirecteurs() { return this.directeurs; }
    public HashMap<Integer, Discipline> getDisciplines() { return this.disciplines; }
    public HashMap<Integer, Niveau> getNiveaux() { return this.niveaux; }
    public HashMap<Integer, Annee> getAnnees() { return this.annees; }
}
