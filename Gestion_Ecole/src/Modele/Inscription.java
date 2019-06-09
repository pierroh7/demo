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
public class Inscription {
    int ID;
    int ID_Eleve;
    int ID_Classe;
    HashMap<Integer, Bulletin> bulletins;
    
    public Inscription(int _ID, int _ID_Eleve, int _ID_Classe) {
        this.ID = _ID;
        this.ID_Eleve = _ID_Eleve;
        this.ID_Classe = _ID_Classe;
        
        DAO<Bulletin> bulletinDAO = DAOFactory.getBulletinDAO();
        this.bulletins = new HashMap<>(((BulletinDAO) bulletinDAO).getTableSpecID(this.ID));
    }
    
    public int getID() { return this.ID; }
    public int getID_Eleve() { return this.ID_Eleve; }
    public int getID_Classe() { return this.ID_Classe; }
    public HashMap<Integer, Bulletin> getBulletins() { return this.bulletins; }
    public Bulletin getSingleBulletin(int cle) { return this.bulletins.get(cle); }

    public void setID(int val) { this.ID = val; }
    public void setID_Eleve(int val) { this.ID_Eleve = val; }
    public void setID_Classe(int val) { this.ID_Classe = val; }
    public void setBulletins(HashMap<Integer, Bulletin> val) { this.bulletins = new HashMap<>(val); }
    public void setSingleBulletin(int cle, Bulletin val) { this.bulletins.replace(cle, val); }

    public void saveBulletins() {
        DAO<Bulletin> bulletinDAO = DAOFactory.getBulletinDAO();
        
        for (Bulletin b : this.bulletins.values()) {
            bulletinDAO.create(b);
        }
    }
    
    public void ajouterBulletin(int cleBulletinMax, Bulletin val) {
        this.bulletins.put(cleBulletinMax, val);
        // augmenter la cle max
    }
    
    public void supprimerBulletin(int cleSupp) {
        this.bulletins.remove(cleSupp);
    }
}
