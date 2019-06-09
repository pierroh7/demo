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
import javax.swing.JComboBox;
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

    public void afficherDetailsBulletin(JTable jTable1, Bulletin bulletin, HashMap<Integer, Enseignant> enseignants, HashMap<Integer, Discipline> disciplines) {
        Controleur C = new Controleur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[5];
        model.setNumRows(0);
        
        for (DetailBulletin d : bulletin.getDetailsBulletin().values()) {
            rowData[0] =  d.getID(); // id detailbulletin
            rowData[1] = C.getDisciplineFromID(C.getEnseignementFromID(d.getID_Enseignement(), enseignants).getID_Discipline(), disciplines).getNom(); // nom discipline
            rowData[2] = C.moyenneDetailBulletin(d); // moyenne
            rowData[3] = d.getCoefficient(); // moyenne
            rowData[4] = d.getAppreciation(); // appreciation
            model.addRow(rowData);
        }
    }
    
    public void afficherNotesDetails(JTable jTable1, DetailBulletin detailBulletin) {
        Controleur C = new Controleur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        model.setNumRows(0);
        
        for (Evaluation e : detailBulletin.getNotes().values()) {
            rowData[0] =  e.getID(); // id note
            rowData[1] = e.getNote(); // note
            rowData[2] = e.getCoefficient(); // coefficient
            rowData[3] = e.getAppreciation(); // appreciation
            model.addRow(rowData);
        }
    }

    public void afficherEnseignantsJTable(JTable jTable1, HashMap<Integer, Enseignant> enseignants) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[3];
        model.setNumRows(0);
        for (Enseignant e : enseignants.values()) {
            rowData[0] = e.getID();
            rowData[1] = e.getNom();
            rowData[2] = e.getPrenom();
            model.addRow(rowData);
        }
    }
    
    public void afficherNiveauxJBox(JComboBox jComboBox1, HashMap<Integer,Niveau> niveaux) {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());
        for (Niveau n : niveaux.values()) {
            jComboBox1.addItem(n.getNom());
        }
    }
    
    public void afficherAnneeJBox(JComboBox jComboBox1, HashMap<Integer, Annee> annees) {
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());
        for (Annee a : annees.values()) {
            jComboBox1.addItem(a.getID());
        }
    }

    public void afficherClassesJTable(JTable jTable1, HashMap<Integer, Niveau> niveaux) {
        Controleur co = new Controleur();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        model.setNumRows(0);
        for (Niveau n : niveaux.values()) {
            for (Classe c : n.getClasses().values()) {
                rowData[0] = c.getID();
                rowData[1] = c.getNom();
                rowData[2] = co.getNiveauFromID(c.getID_Niveau(), niveaux).getNom(); // nom niveau
                rowData[3]  = c.getID_Annee();
                model.addRow(rowData);
            }

        }
    }
}
