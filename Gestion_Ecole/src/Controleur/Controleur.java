/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import Modele.*;
import java.util.HashMap;
import java.util.TreeMap;

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
    
    public Eleve elevesSearchByID(int searchID, TreeMap<Integer, Eleve> eleves) {
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
    
    public Personne connexionSearch(int searchID, TreeMap<Integer, Eleve> eleves, HashMap<Integer, Enseignant> enseignants, HashMap<Integer, Directeur> directeurs) {
        Personne pers = null;
        for (Eleve e : eleves.values()) {
            if (searchID == e.getID()) pers = new Eleve(e);
        }
        for (Enseignant e : enseignants.values()) {
            if (searchID == e.getID()) pers = new Enseignant(e);
        }
        for (Directeur d : directeurs.values()) {
            if (searchID == d.getID()) pers = new Directeur(d);
        }
        return pers;
    }
    
    public int stringToInt(String text) {
        int number = 1;
        boolean cestunint = false;
        try {
             number = Integer.parseInt(text);
             cestunint = true;
             
        } catch (NumberFormatException e) { return 0; }
        return number;
    }
    
    public Classe getClasseFromID(int classeID, HashMap<Integer, Niveau> niveaux) {
        for (Niveau n : niveaux.values()) {
            for (Classe c : n.getClasses().values()) {
                if (classeID == c.getID()) return c;
            }
        }
        return new Classe();
    }
    
    public Trimestre getTrimestreFromID(int trimestreID, HashMap<Integer, Annee> annees) {
        for (Annee a : annees.values()) {
            for (Trimestre t : a.getTrimestres().values()) {
                if (trimestreID == t.getID()) return t;
            }
        }
        return new Trimestre();
    }

    public Enseignement getEnseignementFromID(int enseignementID, HashMap<Integer, Enseignant> enseignants) {
        for (Enseignant e : enseignants.values()) {
            for (Enseignement ee : e.getEnseignements().values()) {
                if (enseignementID == ee.getID()) return ee;
            }
        }
        return new Enseignement();
    }
    
    public Discipline getDisciplineFromID(int disciplineID, HashMap<Integer, Discipline> disciplines) {
        for (Discipline d : disciplines.values()) {
            if (disciplineID == d.getID()) return d;
        }
        return new Discipline();
    }
    
    public Niveau getNiveauFromNom(String niveauNom, HashMap<Integer, Niveau> niveaux) {
        for (Niveau n : niveaux.values()) {
            if (niveauNom == n.getNom()) return n;
        }
        return new Niveau();
    }
    
    public Niveau getNiveauFromID(int niveauID, HashMap<Integer, Niveau> niveaux) {
        for (Niveau n : niveaux.values()) {
            if (niveauID == n.getID()) return n;
        }
        return new Niveau();
    }

    public boolean checkClasseEleve(int classeID, HashMap<Integer,Inscription> inscriptions ) {
        for (Inscription i : inscriptions.values()) {
            if (classeID == i.getID_Classe()) return false;
        }
        return true;
    }

    public Annee getAnneeFromID(int classeID, HashMap<Integer, Annee> annees, HashMap<Integer, Niveau> niveaux) {
        for (Annee a : annees.values()) {
            if (this.getClasseFromID(classeID, niveaux).getID_Annee() == a.getID()) return a;
        }
        return new Annee();
    }
}
