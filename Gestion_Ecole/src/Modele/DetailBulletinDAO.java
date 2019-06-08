/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try {
            String query = "INSERT INTO detailbulletin (ID, IDEnseignement, IDBulletin, Coefficient, Appreciation)"
                         + " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_Enseignement());
            preparedStmt.setInt(3, o.getID_Bulletin());
            preparedStmt.setInt(4, o.getCoefficient());
            preparedStmt.setString(5, o.getAppreciation());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout detailbulletin echoue."); ex.printStackTrace(); }
        return true; 
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
                        rs.getInt("Coefficient"),
                        rs.getString("Appreciation")));
            }
        } catch (SQLException ex) {}
        return detailsBulletin;
    }        

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM detailbulletin";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table detailbulletin supprimee");
            
            query = "ALTER TABLE detailbulletin AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table detailbulletin echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM detailbulletin");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
