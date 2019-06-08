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
public class Eleve extends Personne {
    // Un élève possède plus d'une inscription (sur plusieurs années)
    private HashMap<Integer, Inscription> inscriptions;
    
    public Eleve() {}
    public Eleve(int _ID, int _acces, String _nom, String _prenom) {
        super(_ID, _acces, _nom, _prenom);
        
        DAO<Inscription> inscriptionDAO = DAOFactory.getInscriptionDAO();
        this.inscriptions = new HashMap<>(((InscriptionDAO) inscriptionDAO).getTableSpecID(this.ID));
    }

    public Eleve(Eleve e) {
        super(e.getID(), e.getAcces(), e.getNom(), e.getPrenom());
    }
    
    public HashMap<Integer, Inscription> getInscriptions() { return this.inscriptions; }
    
    public void setInscriptions(HashMap<Integer, Inscription> val) { this.inscriptions = new HashMap<>(val); }

    void saveInscriptions() {
        DAO<Inscription> inscriptionDAO = DAOFactory.getInscriptionDAO();
        
        for (Inscription i : this.inscriptions.values()) {
            inscriptionDAO.create(i);
        }
    }
}
