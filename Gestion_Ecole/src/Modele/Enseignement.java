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
public class Enseignement {
    private int ID;
    private int ID_Discipline;
    private int ID_Enseignant;
    private int ID_Classe;
    
    public Enseignement() {}
    public Enseignement(int _ID, int _ID_Discipline, int _ID_Enseignant, int _ID_Classe) {
        this.ID = _ID;
        this.ID_Discipline = _ID_Discipline;
        this.ID_Enseignant = _ID_Enseignant;
        this.ID_Classe = _ID_Classe;
    }

    public int getID() { return this.ID; }
    public int getID_Discipline() { return this.ID_Discipline; }
    public int getID_Enseignant() { return this.ID_Enseignant; }
    public int getID_Classe() { return this.ID_Classe; }

    public void setID(int val) { this.ID = val; }
    public void setID_Discipline(int val) { this.ID_Discipline = val; }
    public void setID_Enseignant(int val) { this.ID_Enseignant = val; }
    public void setID_Classe(int val) { this.ID_Classe = val; }

}
