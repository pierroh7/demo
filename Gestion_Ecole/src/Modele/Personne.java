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
public class Personne {
    
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
    
    public int getID() { return this.ID; }
    public int getAcces() { return this.acces; }
    public String getNom() { return this.nom; }
    public String getPrenom() { return this.prenom; }
    
    public void setID(int val) { this.ID = val; }
    public void setAcces(int val) { this.acces = val; }
    public void setNom(String val) { this.nom = val; }
    public void setPrenom(String val) { this.prenom = val; }
}
