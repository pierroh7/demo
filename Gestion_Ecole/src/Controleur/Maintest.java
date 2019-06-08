/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;
import Modele.*;
import java.sql.SQLException;
import Affichage.*;
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
            //Ecole ecole = new Ecole();
//            Controleur cont = new Controleur();
//            Affichage affi = new Affichage();
            Graphique graph = new Graphique();
            graph.setVisible(true);
            //graph.afficherEtudiants(ecole.getEleves());
            
            /*for (Eleve e : ecole.getEleves().values()) {
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
            }*/
//            System.out.println("max ID = " + ecole.getClesMax().get("Personne"));
//            ecole.ajouterPersonne(new Eleve(ecole.getClesMax().get("Personne"), 0, "Polo", "Pala"), 1);
//            System.out.println("max ID = " + ecole.getClesMax().get("Personne"));
//            for (Eleve e : ecole.getEleves().values()) {
//                System.out.println(e.getPrenom() + " " + e.getNom() + " " + e.getID());
//                for (Inscription i : e.getInscriptions().values()) {
//                    System.out.println(i.getID() + " " + i.getID_Classe() + " " + i.getID_Eleve());
//                    for (Bulletin b : i.getBulletins().values()) {
//                        System.out.println(b.getID() + " " + b.getAppreciation());
//                        affi.AfficherMoyenne(1, cont.moyenneBulletin(b));
//                        for (DetailBulletin d : b.getDetailsBulletin().values()) {
//                            System.out.println(d.getID() + " " + d.getCoefficient());
//                            affi.AfficherMoyenne(2, cont.moyenneDetailBulletin(d));
//                        }
//                    }
//                }
//            }
//            
//            for (Enseignant e : ecole.getEnseignants().values()) {
//                for (Enseignement ee : e.getEnseignements().values()) {
//                    System.out.println(ee.getID() + " " + ee.getID_Classe() + " " + ee.getID_Discipline() + " " + ee.getID_Enseignant());
//                }
//            }
            //ecole.saveEcole();
        }
}
