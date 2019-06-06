/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.*;

/**
 *
 * @author Nathan
 */
class Eleve extends Personne {

    private String classe;
    private String niveau;
    private ArrayList<Matiere> matieres;

    public Eleve(int _ID, int _acces, String _nom, String _prenom, String _classe, String _niveau) {
        super(_ID, _acces, _nom, _prenom);
    }

    public Eleve() {}

    public Eleve(int id, String string, String string0) {
    }
    
    
}
