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
class Personne {
    
    protected int ID;
    protected int acces;
    protected String nom;
    protected String prenom;
    
    Personne() {}
    Personne(int _ID, int _acces, String _nom, String _prenom) {
        this.ID = _ID;
        this.acces = _acces;
        this.nom = _nom;
        this.prenom = _prenom;
    }
}
