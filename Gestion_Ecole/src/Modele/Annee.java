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
public class Annee {
    private int ID;
    private HashMap<Integer, Trimestre> trimestres;
    
    public Annee(int _ID) {
        this.ID = _ID;
        
        DAO<Trimestre> trimestreDAO = DAOFactory.getTrimestreDAO();
        this.trimestres = new HashMap<>(((TrimestreDAO) trimestreDAO).getTableSpecID(this.ID));
    }
    
    public int getID() { return this.ID; }
    public HashMap<Integer, Trimestre> getTrimestres() { return this.trimestres; }
    public Trimestre getSingleTrimestre(int cle) { return this.trimestres.get(cle); }
    
    public void setID(int val) { this.ID = val; }
    public void setTrimestres(HashMap<Integer, Trimestre> val) { this.trimestres = new HashMap<>(val); }
    public void setSingleTrimestre(int cle, Trimestre val ) { this.trimestres.replace(cle, val); }
}
