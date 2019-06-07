/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Nathan
 */
public class Directeur extends Personne {
    public Directeur() {}
    
    public Directeur(int _ID, int _acces, String _nom, String _prenom) {
        super(_ID, _acces, _nom, _prenom);
    }

    public Directeur(Eleve e) {
        super(e.getID(), e.getAcces(), e.getNom(), e.getPrenom());
    }
}
