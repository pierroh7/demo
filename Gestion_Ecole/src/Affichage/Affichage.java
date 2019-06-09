/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Affichage;

import Controleur.Controleur;
import Modele.*;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nathan
 */
public class Affichage {
    public Affichage() {}
    
    /**
     * Affiche la moyenne du bulletin ou du détail bulletin d'un élève.
     * @param type 1 si on veut afficher la moyenne bulletin, != 1 si la moyenne du detail bulletin
     * @param moy la moyenne à afficher
     */
    public void AfficherMoyenne(int type, double moy) {
        if (type == 1) System.out.println("Moyenne du bulletin : " + moy);
        else System.out.println("Moyenne du detail bulletin : " + moy);
    }
    
    public void AfficherEleves(TreeMap<Integer, Eleve> eleves) {
        for (Eleve e : eleves.values()) {
            System.out.println("ID = " + e.getID() + "\tNom = " + e.getNom() + "\tPrenom = " + e.getPrenom());
        }
    }
    
    public void afficherElevesJTable(JTable jTable1, TreeMap<Integer, Eleve> eleves) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[3];
        model.setNumRows(0);
        for (Eleve e : eleves.values()) {
            rowData[0] = e.getID();
            rowData[1] = e.getNom();
            rowData[2] = e.getPrenom();
            model.addRow(rowData);
        }
    }
    
    public void afficherSingleEleveJTable(JTable jTable1, Eleve eleve) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[3];
        model.setNumRows(0);
        rowData[0] = eleve.getID();
        rowData[1] = eleve.getNom();
        rowData[2] = eleve.getPrenom();
        model.addRow(rowData);
    }
    
    public void afficherClassesInscritesEleve(JTable jTable1, Eleve eleve, HashMap<Integer, Niveau> niveaux) {
        Controleur C = new Controleur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        model.setNumRows(0);
        
        for (Inscription i : eleve.getInscriptions().values()) {
            rowData[0] =  i.getID(); // ID Inscription
            rowData[1] =  C.getClasseFromID(i.getID_Classe(), niveaux).getNom(); // nom classe
            rowData[2] = C.getClasseFromID(i.getID_Classe(), niveaux).getID_Annee(); // annee id 
            rowData[3] = niveaux.get(C.getClasseFromID(i.getID_Classe(), niveaux).getID_Niveau()).getNom(); // nom niveau
            model.addRow(rowData);
        }
    }
    
    public void afficherBulletinsInscription(JTable jTable1, Inscription inscription, HashMap<Integer, Annee> annees) {
        Controleur C = new Controleur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        model.setNumRows(0);
        
        for (Bulletin b : inscription.getBulletins().values()) {
            rowData[0] =  b.getID(); // id bulletin
            rowData[1] = C.getTrimestreFromID(b.getID_Trimestre(), annees).getNumero(); // num trimestre
            rowData[2] = C.moyenneBulletin(b); // moyenne
            rowData[3] = b.getAppreciation(); // appreciation
            model.addRow(rowData);
        }
    }
}
