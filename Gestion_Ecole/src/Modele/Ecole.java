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
    private HashMap<Integer, Enseignant> enseignants;
    private HashMap<Integer, Directeur> directeurs;
    private HashMap<Integer, Discipline> disciplines;
    private HashMap<Integer, Niveau> niveaux;
    private HashMap<Integer, Annee> annees;
    private HashMap<String, Integer> clesMax;

    /**
     * Contructeur par défaut - Il charge toutes les tables en cascade.
     */
    public Ecole() {
        DAO<Eleve> eleveDAO = DAOFactory.getEleveDAO();
        DAO<Enseignant> enseignantDAO = DAOFactory.getEnseignantDAO();
        DAO<Directeur> directeurDAO = DAOFactory.getDirecteurDAO();
        DAO<Discipline> disciplineDAO = DAOFactory.getDisciplineDAO();
        DAO<Niveau> niveauDAO = DAOFactory.getNiveauDAO();
        DAO<Annee> anneeDAO = DAOFactory.getAnneeDAO();
        
        this.eleves = new HashMap<>(eleveDAO.getTable()); // Récupère les élèves
        this.enseignants = new HashMap<>(enseignantDAO.getTable()); // Récupère les profs
        this.directeurs = new HashMap<>(directeurDAO.getTable()); // Récupère les directeurs
        this.disciplines = new HashMap<>(disciplineDAO.getTable()); // Récupère les disciplines
        this.niveaux = new HashMap<>(niveauDAO.getTable()); // Récupère les niveaux
        this.annees = new HashMap<>(anneeDAO.getTable());  // Récupère les annees
        this.clesMax = new HashMap<>();
        
        this.addClesMax(); // Pour l'auto incrémentation des ID 
    }
    
    // Getters
    public HashMap<Integer, Eleve> getEleves() { return this.eleves; }
    public HashMap<Integer, Enseignant> getEnseignants() { return this.enseignants; }
    public HashMap<Integer, Directeur> getDirecteurs() { return this.directeurs; }
    public HashMap<Integer, Discipline> getDisciplines() { return this.disciplines; }
    public HashMap<Integer, Niveau> getNiveaux() { return this.niveaux; }
    public HashMap<Integer, Annee> getAnnees() { return this.annees; }
    public HashMap<String, Integer> getClesMax() { return this.clesMax; }
    
    /**
     * Ajoute l'ID maximum pour chaque classe.
     */
    public void addClesMax() {
        this.clesMax.put("Personne", DAOFactory.getEleveDAO().getMaxID() + 1);
        this.clesMax.put("Annee", DAOFactory.getAnneeDAO().getMaxID() + 1);
        this.clesMax.put("Bulletin", DAOFactory.getBulletinDAO().getMaxID() + 1);
        this.clesMax.put("Classe", DAOFactory.getClasseDAO().getMaxID() + 1);
        this.clesMax.put("DetailBulletin", DAOFactory.getDetailBulletinDAO().getMaxID() + 1);
        this.clesMax.put("Discipline", DAOFactory.getDisciplineDAO().getMaxID() + 1);
        this.clesMax.put("Enseignement", DAOFactory.getEnseignementDAO().getMaxID() + 1);
        this.clesMax.put("Evaluation", DAOFactory.getEvaluationDAO().getMaxID() + 1);
        this.clesMax.put("Inscription", DAOFactory.getInscriptionDAO().getMaxID() + 1);
        this.clesMax.put("Niveau", DAOFactory.getNiveauDAO().getMaxID() + 1);
        this.clesMax.put("Trimestre", DAOFactory.getTrimestreDAO().getMaxID() + 1);
    }
    
    /**
     * Incrémente la clé d'une des tables.
     * @param cle la clé à incrémenter.
     */
    public void incrementCleMax(String cle) {
        this.clesMax.replace(cle, this.clesMax.get(cle) + 1);
    }
    
    /**
     * Sauvegarde l'école entière.
     */
    public void saveEcole() {
        DAO<Ecole> ecoleDAO = DAOFactory.getEcoleDAO();
        ((EcoleDAO) ecoleDAO).deleteAllTables();
        this.savePersonnes();
        this.saveNiveaux();
        this.saveDisciplines();
        this.saveAnnees();
        
        for (Niveau n : this.niveaux.values()) {
            n.saveClasses();
        }
        for (Annee a : this.annees.values()) {
            a.saveTrimestres();
        }
        for (Eleve e : this.eleves.values()) {
            e.saveInscriptions();
        }
        for (Enseignant e : this.enseignants.values()) {
            e.saveEnseignements();
        }
        for (Eleve e : this.eleves.values()) {
            for (Inscription i : e.getInscriptions().values()) {
                i.saveBulletins();
                for (Bulletin b : i.getBulletins().values()) {
                    b.saveDetailsBulletin();                    
                    for (DetailBulletin d : b.getDetailsBulletin().values()) {
                        d.saveEvaluations();
                    }
                }
            }
        }
    }
    
    /**
     * Sauvegarde toutes les personnes.
     */
    public void savePersonnes() {
        DAO<Eleve> eleveDAO = DAOFactory.getEleveDAO();
        DAO<Directeur> directeurDAO = DAOFactory.getDirecteurDAO();
        DAO<Enseignant> enseignantDAO = DAOFactory.getEnseignantDAO();
        
        for (Eleve el : this.eleves.values()) {
            eleveDAO.create(el);
        }
        for (Directeur d : this.directeurs.values()) {
            directeurDAO.create(d);
        }
        for (Enseignant en : this.enseignants.values()) {
            enseignantDAO.create(en);
        }
        System.out.println("Personnes sauvegardees dans la BDD");
    }
    
    /**
     * Sauvegarde tous les niveaux.
     */
    public void saveNiveaux() {
        DAO<Niveau> niveauDAO = DAOFactory.getNiveauDAO();
        
        for (Niveau n : this.niveaux.values()) {
            niveauDAO.create(n);
        }
        System.out.println("Niveaux sauvegardees dans la BDD");
    }
    
    /**
     * Sauvegarde toutes les disciplines.
     */
    public void saveDisciplines() {
        DAO<Discipline> disciplineDAO = DAOFactory.getDisciplineDAO();
        
        for (Discipline d : this.disciplines.values()) {
            disciplineDAO.create(d);
        }
        System.out.println("Disciplines sauvegardees dans la BDD");
    }
    
    /**
     * Sauvegarde toutes les années.
     */
    public void saveAnnees() {
        DAO<Annee> anneeDAO = DAOFactory.getAnneeDAO();
        
        for (Annee a : this.annees.values()) {
            anneeDAO.create(a);
        }
        System.out.println("Annees sauvegardees dans la BDD");
    }
    
    /**
     * Ajoute une personne de type, élève, directeur ou enseignant à la HashMap.
     * @param e la personne à ajouter
     * @param type 1 pour un élève, 2 pour un directeur, 3 pour un enseignant
     */
    public void ajouterPersonne(Personne e, int type) {
        if (type == 1) this.eleves.put(this.clesMax.get("Personne"), (Eleve) e);
        if (type == 2) this.directeurs.put(this.clesMax.get("Personne"), (Directeur) e);
        if (type == 3) this.enseignants.put(this.clesMax.get("Personne"), (Enseignant) e);
        this.incrementCleMax("Personne");
        System.out.println("Personne ajoutee");
    }
}
