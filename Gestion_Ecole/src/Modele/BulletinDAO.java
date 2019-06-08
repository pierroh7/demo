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
public class BulletinDAO extends DAO<Bulletin> {

    public BulletinDAO(Connection conn) {
        super(conn);
    }
    @Override
    public boolean create(Bulletin o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bulletin o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bulletin find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Bulletin> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Bulletin> getTableSpecID(int ID_Inscription) {
        HashMap<Integer, Bulletin> bulletins = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM bulletin WHERE IDInscription = " + ID_Inscription);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                bulletins.put(ID, new Bulletin(
                        ID,
                        rs.getInt("IDInscription"),
                        rs.getInt("IDTrimestre"),
                        rs.getString("Appreciation")));
            }
        } catch (SQLException ex) {}
        return bulletins;
    }    
}
