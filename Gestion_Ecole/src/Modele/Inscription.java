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
public class Inscription {
    int ID;
    int ID_Eleve;
    int ID_Classe;
    HashMap<Integer, Bulletin> bulletins;
    
    public Inscription(int _ID, int _ID_Eleve, int _ID_Classe) {
        this.ID = _ID;
        this.ID_Eleve = _ID_Eleve;
        this.ID_Classe = _ID_Classe;
    }
    
    public int getID() { return this.ID; }
    public int getID_Eleve() { return this.ID_Eleve; }
    public int getID_Classe() { return this.ID_Classe; }
}
