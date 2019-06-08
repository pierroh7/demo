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
    private String appreciation;
    private HashMap<Integer, DetailBulletin> detailsBulletin;
    
    public Bulletin(int _ID, int _ID_Inscription, int _ID_Trimestre, String _appreciation) {
        this.ID = _ID;
        this.ID_Inscription = _ID_Inscription;
        this.ID_Trimestre = _ID_Trimestre;
        this.appreciation = _appreciation;
        
        DAO<DetailBulletin> detailBulletinDAO = DAOFactory.getDetailBulletinDAO();
        this.detailsBulletin = new HashMap<>(((DetailBulletinDAO) detailBulletinDAO).getTableSpecID(this.ID));
    }
    
    public int getID() { return this.ID; }
    public int getID_Inscription() { return this.ID_Inscription; }
    public int getID_Trimestre() { return this.ID_Trimestre; }
    public String getAppreciation() { return this.appreciation; }
    public HashMap<Integer, DetailBulletin> getDetailsBulletin() { return this.detailsBulletin; }
    public DetailBulletin getSingleDetail(int cle) { return this.detailsBulletin.get(cle); }
    
    public void setID(int val) {  }
    public void setID_Inscription(int val) {  }
    public void setIDTrimestre(int val) {  }
    public void setAppreciation(String val) {  }
    public void setDetailsBulletin(HashMap<Integer, DetailBulletin> val) { this.detailsBulletin = new HashMap<>(val); }
    public void setSingleDetail(int cle, DetailBulletin val) { this.detailsBulletin.replace(cle, val); }

    void saveDetailsBulletin() {
        DAO<DetailBulletin> detailBulletinDAO = DAOFactory.getDetailBulletinDAO();
        
        for (DetailBulletin d : this.detailsBulletin.values()) {
            detailBulletinDAO.create(d);
        }
    }
    
    void ajouterDetailBulletin(int cleDetailMax, DetailBulletin val) {
        this.detailsBulletin.put(cleDetailMax, val);
    }
} 
