/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;
import Modele.*;
import java.sql.SQLException;


import java.util.ArrayList;

/**
 *
 * @author Nathan
 */
public class Maintest {
        public static void main(String[] args) {
            try {
                Connexion co = new Connexion("ecolejava", "root", "");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("La connexion n'a pas pu être effectuée.");
            }
            System.out.println("hello world!");
            Ecole ecole = new Ecole();
            
            for (Eleve e : ecole.getEleves().values()) {
                System.out.println(e.getNom() + " " + e.getPrenom());
                for (Inscription i : e.getInscriptions().values()) {
                    System.out.println(i.getID() + " " + i.getID_Classe() + " " + i.getID_Eleve());
                    for (Bulletin b : i.getBulletins().values()) {
                        System.out.println(b.getID() + " " + b.getAppreciation());
                    }
                }
            }
            for (Directeur d : ecole.getDirecteurs().values()) {
                System.out.println(d.getNom() + " " + d.getPrenom());
            }
            for (Enseignant e : ecole.getEnseignants().values()) {
                System.out.println(e.getNom() + " " + e.getPrenom());
            }
        }
}
