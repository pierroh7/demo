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
public class DetailBulletin {
    private int ID;
    private int ID_Bulletin;
    private int ID_Enseignement;
    private String appreciation;
    private HashMap<Integer, Evaluation> notes;

    public DetailBulletin() {}
    
    public DetailBulletin(int _ID, int _ID_Bulletin, int _ID_Enseignement, String _appreciation) {
        this.ID = _ID;
        this.ID_Bulletin = _ID_Bulletin;
        this.ID_Enseignement = _ID_Enseignement;
        this.appreciation = _appreciation;
        
        DAO<Evaluation> evaluationDAO = DAOFactory.getEvaluationDAO();
        this.notes = new HashMap<>(((EvaluationDAO) evaluationDAO).getTableSpecID(ID));
    }

    public int getID() { return this.ID; }
    public int getID_Bulletin() { return this.ID_Bulletin; }
    public int getID_Enseignement() { return this.ID_Enseignement; }
    public String getAppreciation() { return this.appreciation; }
    public HashMap<Integer, Evaluation> getNotes() { return this.notes; }
    public Evaluation getSingleNote(int cle) { return this.notes.get(cle); }

    public void setID(int val) { this.ID = val; }
    public void setID_Bulletin(int val) { this.ID_Bulletin = val; }
    public void setID_Enseignement(int val) { this.ID_Enseignement = val; }
    public void setAppreciation(String val) { this.appreciation = val; }
    public void setNotes(HashMap<Integer, Evaluation> val) { this.notes = new HashMap<>(val); }
    public void setSingleNote(int cle, Evaluation val) { this.notes.replace(cle, val); }
    
    
    
    
}
