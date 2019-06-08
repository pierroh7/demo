/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Affichage;

import Modele.*;
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
        for (Eleve e : eleves.values()) {
            rowData[0] = e.getID();
            rowData[1] = e.getNom();
            rowData[2] = e.getPrenom();
            model.addRow(rowData);
        }
    }
}
