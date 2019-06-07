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
public class Bulletin {
    private int ID;
    private int ID_Inscription;
    private int ID_Trimestre;
    private HashMap<Integer, DetailBulletin> detailsBulletin;
}
