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
public class Classe {
    private int ID;
    private int ID_Niveau;
    private int ID_Annee;
    private String nom;
    
    public Classe() {}
    public Classe(int _ID, int _ID_Niveau, int _ID_Annee, String _nom) {
        this.ID = _ID;
        this.ID_Niveau = _ID_Niveau;
        this.ID_Annee = _ID_Annee;
        this.nom = _nom;
    }

    public int getID() { return this.ID; }
    public int getID_Niveau() { return this.ID_Niveau; }
    public int getID_Annee() { return this.ID_Annee; }
    public String getNom() { return this.nom; }

    public void setID(int val) { this.ID = val; }
    public void setID_Niveau(int val) { this.ID_Niveau = val; }
    public void setID_Annee(int val) { this.ID_Annee = val; }
    public void setNom(String val) { this.nom = val; }
}
