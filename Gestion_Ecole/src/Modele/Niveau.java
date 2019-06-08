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
public class Niveau {
    
    private int ID;
    private String nom;
    private HashMap<Integer, Classe> classes;
    
    public Niveau(int _ID, String _nom) {
        this.ID = _ID;
        this.nom = _nom;
        
        DAO<Classe> classeDAO = DAOFactory.getClasseDAO();
        this.classes = new HashMap<>(((ClasseDAO) classeDAO).getTableSpecID(this.ID));
    }

    public int getID() { return this.ID; }
    public String getNom() { return nom; }
    public HashMap<Integer, Classe> getClasses() { return this.classes; }
    public Classe getSingleClasse(int cle) { return this.classes.get(cle); }

    public void setID(int val) { this.ID = val; }
    public void setNom(String val) { this.nom = val; }
    public void setClasses(HashMap<Integer, Classe> val) { this.classes = new HashMap<>(val); }
    public void setSingleClasse(int cle, Classe val) { this.classes.replace(cle, val); }

    void saveClasses() {
        DAO<Classe> classeDAO = DAOFactory.getClasseDAO();
        
        for (Classe c : this.classes.values()) {
            classeDAO.create(c);
        }
    }
    
    public void ajouterClasse(int cleClasseMax, Classe val) {
        this.classes.put(cleClasseMax, val);
        // augmenter la cle max
    }
    
    public void supprimerClasse(int cleSupp) {
        this.classes.remove(cleSupp);
    }
}
