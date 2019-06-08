/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class DetailBulletinDAO extends DAO<DetailBulletin> {

    DetailBulletinDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(DetailBulletin o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(DetailBulletin o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetailBulletin find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, DetailBulletin> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, DetailBulletin> getTableSpecID(int ID_Bulletin) {
        HashMap<Integer, DetailBulletin> detailsBulletin = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM detailbulletin WHERE IDBulletin = " + ID_Bulletin);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                detailsBulletin.put(ID, new DetailBulletin(
                        ID,
                        rs.getInt("IDBulletin"),
                        rs.getInt("IDEnseignement"),
                        rs.getString("Appreciation")));
            }
        } catch (SQLException ex) {}
        return detailsBulletin;
    }        
    
}
