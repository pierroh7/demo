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
public class BulletinDAO extends DAO<Bulletin> {

    public BulletinDAO(Connection conn) {
        super(conn);
    }
    @Override
    public boolean create(Bulletin o) {
        try {
            String query = "INSERT INTO bulletin (ID, IDInscription, IDTrimestre, Appreciation)"
                         + " VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_Inscription());
            preparedStmt.setInt(3, o.getID_Trimestre());
            preparedStmt.setString(4, o.getAppreciation());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout bulletin echoue."); }
        return true;
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

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM bulletin";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table bulletin supprimee");
            
            query = "ALTER TABLE bulletin AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table bulletin echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM bulletin");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
