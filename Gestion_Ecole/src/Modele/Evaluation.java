/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Nathan
 */
public class Evaluation {
    int ID;
    int ID_DetailBulletin;
    double note;
    int coefficient;
    String appreciation;
    
    public Evaluation(int _ID, int _ID_DetailBulletin, double _note, int _coef, String _app) {
        this.ID = _ID;
        this.ID_DetailBulletin = _ID_DetailBulletin;
        this.note = _note;
        this.coefficient = _coef;
        this.appreciation = _app;
    }
}
