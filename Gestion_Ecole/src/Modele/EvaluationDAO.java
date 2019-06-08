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
public class EvaluationDAO extends DAO<Evaluation> {

    public EvaluationDAO(Connection conn) {
        super(conn);
    }
    
    @Override
    public boolean create(Evaluation o) {
        try {
            String query = "INSERT INTO evaluation (ID, IDDetailBulletin, Note, Coefficient, Appreciation)"
                         + " VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setInt(2, o.getID_DetailBulletin());
            preparedStmt.setDouble(3, o.getNote());
            preparedStmt.setDouble(4, o.getCoefficient());
            preparedStmt.setString(5, o.getAppreciation());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout evaluation echoue."); }
        return true;         
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Evaluation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evaluation find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Evaluation> getTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HashMap<Integer, Evaluation> getTableSpecID(int ID_DetailBulletin) {
        HashMap<Integer, Evaluation> notes = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM evaluation WHERE IDDetailBulletin = " + ID_DetailBulletin);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                notes.put(ID, new Evaluation(
                        ID,
                        rs.getInt("IDDetailBulletin"),
                        rs.getInt("Note"),
                        rs.getInt("Coefficient"),
                        rs.getString("Appreciation")));
            }
        } catch (SQLException ex) {}
        return notes;
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM evaluation";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table evaluation supprimee");
            
            query = "ALTER TABLE evaluation AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table evaluation echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM evaluation");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
