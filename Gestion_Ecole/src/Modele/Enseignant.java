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
public class Enseignant extends Personne {
    private HashMap<Integer, Enseignement> enseignements;
    
    public Enseignant() {}
    
    public Enseignant(int _ID, int _acces, String _nom, String _prenom) {
        super(_ID, _acces, _nom, _prenom);
        
        DAO<Enseignement> enseignementDAO = DAOFactory.getEnseignementDAO();
        this.enseignements = new HashMap<>(((EnseignementDAO) enseignementDAO).getTableSpecID(this.ID));
    }
    
    public Enseignant(Enseignant e) {
         super(e.getID(), e.getAcces(), e.getNom(), e.getPrenom());
    }
    
    public HashMap<Integer, Enseignement> getEnseignements() { return this.enseignements; }
    
    public void setEnseignements(HashMap<Integer, Enseignement> val) { this.enseignements = new HashMap<>(val); }
}
