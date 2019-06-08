/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Modele.*;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class Controleur {
    public Controleur() {}
    
    public double moyenneDetailBulletin(DetailBulletin d) {
        double sommeNotes = 0.0;
        int sommeCoef = 0;
        for (Evaluation e : d.getNotes().values()) {
            sommeCoef += e.getCoefficient();
            sommeNotes += (double) e.getCoefficient() * e.getNote();
        }
        double moy = sommeNotes / (double) sommeCoef;
        return moy;
    }
    
    public double moyenneBulletin(Bulletin b) {
        double sommeMoyDetails = 0.0;
        int sommeCoef = 0;
        for (DetailBulletin d : b.getDetailsBulletin().values()) {
            sommeCoef += d.getCoefficient();
            sommeMoyDetails += this.moyenneDetailBulletin(d) * d.getCoefficient();
        } 
        double moy = sommeMoyDetails / (double) sommeCoef;
        return moy;
    }
    
    public Eleve elevesSearchByID(int searchID, HashMap<Integer, Eleve> eleves) {
        Eleve found = new Eleve();
        for (Eleve e : eleves.values()) {
            if (searchID == e.getID()) found = new Eleve(e);
        }
        return found;
    }
    
    public HashMap<Integer, Eleve> elevesSearchByNom(String searchNom, HashMap<Integer, Eleve> eleves) {
        HashMap<Integer, Eleve> found = new HashMap<>();
        for (Eleve e : eleves.values()) {
            if (searchNom.equals(e.getPrenom()) || searchNom.equals(e.getNom())) found.put(e.getID(), e);
        }
        return found;
    }
}
