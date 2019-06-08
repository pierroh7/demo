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

    public int getID() { return this.ID; }
    public int getID_DetailBulletin() { return this.ID_DetailBulletin; }
    public double getNote() { return this.note; }
    public int getCoefficient() { return this.coefficient; }
    public String getAppreciation() { return this.appreciation; }

    public void setID(int val) { this.ID = val; }
    public void setID_DetailBulletin(int val) { this.ID_DetailBulletin = val; }
    public void setNote(double val) { this.note = val; }
    public void setCoefficient(int val) { this.coefficient = val; }
    public void setAppreciation(String val) { this.appreciation = val; }
    
    
}
