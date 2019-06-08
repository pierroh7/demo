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
public class Discipline {
    private int ID;
    private String nom;
    
    public Discipline() {}
    public Discipline(int _ID, String _nom) {
        this.ID = _ID;
        this.nom = _nom;
    }

    public int getID() { return this.ID; }
    public String getNom() { return this.nom; }
    
    public void setID(int val) { this.ID = val; }
    public void setID(String val) { this.nom = val; }
    


}
