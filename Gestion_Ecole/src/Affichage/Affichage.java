/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Affichage;

import Modele.*;
import java.util.TreeMap;

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
}
