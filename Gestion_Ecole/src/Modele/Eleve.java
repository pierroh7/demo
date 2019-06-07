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
    private HashMap<Integer, Inscription> classes;
    
    public Eleve() {}
    
    public Eleve(int _ID, int _acces, String _nom, String _prenom) {
        super(_ID, _acces, _nom, _prenom);
        DAO<Inscription> inscriptionDAO = DAOFactory.getInscriptionDAO();
        this.classes = new HashMap<>(((InscriptionDAO) inscriptionDAO).getTableSpecID(this.ID));
    }

    public Eleve(Eleve e) {
        super(e.getID(), e.getAcces(), e.getNom(), e.getPrenom());
    }
    
    public HashMap<Integer, Inscription> getClasses() { return this.classes; }
}
