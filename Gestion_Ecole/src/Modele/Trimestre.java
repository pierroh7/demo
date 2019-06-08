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
public class Trimestre {
    private int ID;
    private int ID_Annee;
    private int numero;
    private String debut;
    private String fin;
    
    public Trimestre(int _ID, int _ID_Annee, int _numero, String _debut, String _fin) {
        this.ID = _ID;
        this.ID_Annee = _ID_Annee;
        this.numero = _numero;
        this.debut = _debut;
        this.fin = _fin;
    }

    public int getID() { return this.ID; }
    public int getID_Annee() { return this.ID_Annee; }
    public int getNumero() { return this.numero; }
    public String getDebut() { return this.debut; }
    public String getFin() { return this.fin; }

    public void setID(int ID) { this.ID = ID; }
    public void setID_Annee(int ID_Annee) { this.ID_Annee = ID_Annee; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setDebut(String debut) { this.debut = debut; }
    public void setFin(String fin) { this.fin = fin; }
}
